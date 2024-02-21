package eapli.base.daemon.motorFluxoAtividade.presentation;

import eapli.base.Application;
import eapli.base.daemon.motorFluxoAtividade.MotorFluxoAtividadeDaemon;
import eapli.base.daemon.motorFluxoAtividade.Teste.TcpChatCliGui;
import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;
import eapli.base.daemon.motorFluxoAtividade.algoritmos.Algoritmo;
import eapli.base.daemon.motorFluxoAtividade.protocol.SDP2021ProtocolMessageParser;
import eapli.base.daemon.motorFluxoAtividade.protocol.SDP2021ProtocolRequest;
import eapli.base.fluxotarefaresolucao.domain.FluxoResolucao;
import eapli.base.fluxotarefaresolucao.domain.TarefaAprovRes;
import eapli.base.fluxotarefaresolucao.domain.TarefaExecRes;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.FluxoTarefa;
import eapli.base.servicomanagement.domain.Pedido;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repositories.PedidoRepository;
import eapli.base.servicomanagement.repositories.ServicoRepository;
import eapli.base.tarefamanagement.domain.TarefaExecucao;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class MotorFluxoAtividadeServer {

    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "forgotten";

    private static final Logger LOGGER = LogManager.getLogger(MotorFluxoAtividadeServer.class);

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(final Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            final InetAddress clientIP = clientSocket.getInetAddress();
            LOGGER.info("Acepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try (DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                 DataInputStream in = new DataInputStream(clientSocket.getInputStream());) {
                byte[] bytes = new byte[258];
                while (in.read() != 0) {
                    in.read(bytes);
                    LOGGER.debug("Received message:----\n{}\n----", new String(bytes));
                    final SDP2021ProtocolRequest request = SDP2021ProtocolMessageParser.parse(bytes);
                    final byte[] response = request.execute();
                    System.out.println(bytes);
                    // TAMANHO
                    out.write(response.length);
                    out.write(response, 0, response.length);

                    if (bytes[Constantes.CODE_POS] == Constantes.LOGIN) {
                        AtualizarDashBoard atualizarDashBoard = new AtualizarDashBoard(clientSocket);
                        atualizarDashBoard.start(bytes);
                    }

                    LOGGER.debug("Sent message:----\n{}\n----", response);
                    if (request.isGoodbye()) {
                        break;
                    }
                }
            } catch (final Exception e) {
                LOGGER.error(e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket {}", e.getMessage());
                }
            }
        }
    }

    private static class ExecutorAutomaticoHandler extends Thread {
        private static final Logger LOGGER1 = LogManager.getLogger(ExecutorAutomaticoHandler.class);

        public ExecutorAutomaticoHandler() {

        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    PedidoRepository pedidoRepository = PersistenceContext.repositories().pedido();
                    Iterable<Pedido> pedidos = pedidoRepository.findAll();
                    ServicoRepository servicoRepository = PersistenceContext.repositories().servicos();
                    Iterable<Servico> servicos = servicoRepository.findAll();
                    for (Pedido pedido : pedidos) {

                        FluxoResolucao fluxoResolucao = pedido.fluxoResolucao();

                        TarefaExecRes resolucao = fluxoResolucao.tarefaExecucaoResolucao();
                        if (!resolucao.tarefaExecucao().manual() && resolucao.estado() == TarefaExecRes.EstadoTarefaExecucao.Pendente && (fluxoResolucao.tarefaAprovacaoResolucao() == null ||
                                (fluxoResolucao.tarefaAprovacaoResolucao() != null && fluxoResolucao.tarefaAprovacaoResolucao().estado() == TarefaAprovRes.EstadoTarefaAprovacao.Aprovada))) {
                            new Thread(() -> {
//                             code goes here.
                                PedidoRepository pedidoRepository1 = PersistenceContext.repositories().pedido();
                                pedido.mudarEstadoTarefaDoing();
                                pedidoRepository1.save(pedido);
                                pedidoRepository1 = PersistenceContext.repositories().pedido();
                                if (sendPacket(pedido)) {
//                                    pedido.mudarEstadoTarefaDone();
                                } else {
                                    pedido.mudarEstadoTarefaPendente();
                                }
                                pedidoRepository1.save(pedido);
                            }).start();
                        }
                    }
//                    for (Servico servico : servicos) {
//                        FluxoTarefa fluxoTarefa = servico.fluxoTarefa();
//                        TarefaExecucao resolucao = fluxoTarefa.tarefaExecucao();
//                        if (!resolucao.manual() && resolucao.estado() == TarefaExecucao.EstadoTarefaResolucao.Pendente) {
//                            new Thread(() -> {
////                             code goes here.
//                                ServicoRepository servicoRepository1 = PersistenceContext.repositories().servicos();
//                                servico.mudarEstadoTarefaDoing();
//                                servicoRepository1.save(servico);
//
//                                servicoRepository1 = PersistenceContext.repositories().servicos();
//                                if (sendPacket(resolucao)) {
//                                    servico.mudarEstadoTarefaDone();
//                                } else {
//                                    servico.mudarEstadoTarefaPendente();
//                                }
//                                servicoRepository1.save(servico);
//                            }).start();
//                        }
//                    }
                    synchronized (MotorFluxoAtividadeDaemon.algoritmo) {
                        MotorFluxoAtividadeDaemon.algoritmo.notify();
                    }

                    sleep(3000);


                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                    if (i == 3) {
                        LOGGER.debug("Watting 30 seconds to try a new connection! ");
                    }
                    LOGGER.debug("Watting 30 seconds to try a new connection! ");
                    LOGGER.debug("Attempt " + i);
                    try {
                        sleep(30000);
                    } catch (InterruptedException d) {
                        LOGGER.error(d.getMessage());
                    }
                }
            }
        }

        private boolean sendPacket(Pedido pedido) {
            try {

                System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
                System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

                // Use this certificate and private key as server certificate
                System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
                System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

                InetAddress serverIP = null;
                Socket socket = null;

                LOGGER.info("Iniciar sessao com o servidor...");

                serverIP = InetAddress.getByName("10.8.0.81");

                SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
                assert serverIP != null;
                int attempt = 0;
                LOGGER1.warn(serverIP.getHostAddress());

                while (true) {
                    try {
                        attempt++;
                        socket = (SSLSocket) sf.createSocket(serverIP, 32705);
                        break;
                    } catch (IOException i) {
                        if (attempt == 3) {
                            LOGGER1.warn("Connection Failed!!");
                            return false;
                        }
                        LOGGER1.warn("Watting 30 seconds to try a new connection! ");
                        LOGGER1.warn("Attempt " + attempt);
                        System.out.println();
                        sleep(0);
                    }
                }

                ((SSLSocket) socket).startHandshake();

                DataInputStream in = new DataInputStream(socket.getInputStream());

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = null;
                // TarefaExecucao tarefaExecucao = new TarefaExecucao();

                byte[] yourBytes;
                try {
                    out = new ObjectOutputStream(bos);
                    out.writeObject(pedido);
                    out.flush();
                    yourBytes = bos.toByteArray();
                } finally {
                    try {
                        bos.close();
                    } catch (IOException ex) {
                        // ignore close exception
                    }
                }
                byte[] resposta = new byte[3];

                resposta[Constantes.VERSAO_POS] = Constantes.VERSAO;
                resposta[Constantes.CODE_POS] = Constantes.RECEBER_TAREFA;
                resposta[Constantes.SIZE_POS] = 0;
                DataOutputStream outt = new DataOutputStream(socket.getOutputStream());

                outt.write((byte) resposta.length);
                outt.write(resposta, 0, (byte) resposta.length);

                int nr = in.read();
                in.read(resposta, 0, nr);

                int size;


                // mandar primeiros bytes
                int len = yourBytes.length;

                if (len <= 124) {
                    size = len;
                } else {
                    size = 124;
                }

                byte[] resposta2 = new byte[size + 3];

                byte[] copy = new byte[size];

                int i;
                int a;
                for (i = 0, a = 3; i < size; i++, a++) {
                    resposta2[a] = yourBytes[i];
                }

                resposta2[Constantes.VERSAO_POS] = Constantes.VERSAO;
                resposta2[1] = Integer.valueOf(Constantes.RECEBER_SEGMENTO).byteValue(); // 255
                resposta2[2] = Integer.valueOf(size).byteValue(); // 255
                outt.write((byte) resposta2.length);
                outt.write(resposta2, 0, (byte) resposta2.length);


                nr = in.read();
                in.read(resposta, 0, nr);

                int yourBytesIndex = 124;
                len -= 124;

                while (len > 0) {

                    if (len <= 124) {
                        size = len;
                    } else {
                        size = 124;
                    }
                    byte[] copy2 = new byte[size + 3];
                    for (i = 0; i < size; i++) {
                        copy2[i + 3] = yourBytes[yourBytesIndex];
                        yourBytesIndex++;
                    }

                    copy2[Constantes.VERSAO_POS] = Constantes.VERSAO;
                    copy2[Constantes.CODE_POS] = Integer.valueOf(Constantes.CONTINUACAO_SEGMENTO).byteValue();
                    copy2[Constantes.SIZE_POS] = Integer.valueOf(size).byteValue(); // 255

                    outt.write((byte) copy2.length);
                    outt.write(copy2, 0, (byte) copy2.length);

                    nr = in.read();
                    in.read(resposta, 0, nr);

                    len -= size;
                }

                byte[] resposta3 = new byte[3];

                resposta3[Constantes.VERSAO_POS] = Constantes.VERSAO;
                resposta3[Constantes.CODE_POS] = Constantes.TAREFA_TERMINADA;
                resposta3[Constantes.SIZE_POS] = 0;//                len -= 255;

                outt.write((byte) resposta3.length);
                outt.write(resposta3, 0, (byte) resposta3.length);
                LOGGER.info("Tarefa ENVIADA");
                nr = in.read();
                in.read(resposta, 0, nr);
                LOGGER.info("Tarefa ENVIADA3");
//                nr = in.read();
//                in.read (resposta, 0, nr);
//
//                if (resposta[Constantes.CODE_POS] == Constantes.TAREFA_TERMINADA) {
//                    LOGGER.info("Tarefa executada");
//                } else {
//                    throw new IOException("Code Errado");
//                }

                socket.close();

            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                return false;
            }
            return true;
        }

    }


    /**
     * Wait for connections.
     *
     * @param port
     */
    @SuppressWarnings("java:S2189")
    private void listen(final int port) {
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket ssl;
        try {
            ssl = (SSLServerSocket) sslF.createServerSocket(port);
            while (true) {
                final SSLSocket clientSocket = (SSLSocket) ssl.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (final IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private void write(final int port) throws IOException, InterruptedException {
        TcpChatCliGui.doShow();
    }

    /**
     * Wait for connections.
     *
     * @param port
     * @param blocking if {@code true} the socket runs in its own thread.
     */
    public void start(final int port, final boolean blocking) {
        if (blocking) {
            new ExecutorAutomaticoHandler().start();
            listen(port);
        } else {
            new Thread(() -> listen(port)).start();
        }
    }


}
