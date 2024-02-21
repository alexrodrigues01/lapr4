package eapli.base.daemon.executorTarefasAutomaticas.presentation;


import eapli.base.daemon.executorTarefasAutomaticas.ExecutorTarefasAutomaticasDaemon;
import eapli.base.daemon.executorTarefasAutomaticas.protocol.SDP2021ProtocolMessageParserExecutor;
import eapli.base.daemon.executorTarefasAutomaticas.protocol.SDP2021ProtocolRequest;
import eapli.base.daemon.executorTarefasAutomaticas.utils.Constantes;
import eapli.base.servicomanagement.domain.Pedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ExecutorTarefasAutomaticasServer {

    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "forgotten";


    private static final Logger LOGGER = LogManager.getLogger(ExecutorTarefasAutomaticasServer.class);

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;


        public ClientHandler(final Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            final InetAddress clientIP = clientSocket.getInetAddress();
            LOGGER.debug("Acepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());
            try (DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                 DataInputStream in = new DataInputStream(clientSocket.getInputStream());) {
                readAndSendMessage(out, in);
            } catch (final Exception e) {
                LOGGER.error(e);
            } finally {
                try {
                    clientSocket.close();
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket", e);
                }
            }
        }

        private void readAndSendMessage(DataOutputStream out, DataInputStream in) throws IOException, ClassNotFoundException, InterruptedException {
            byte[] bytes = new byte[258];
            while (in.read() != 0) {
                in.read(bytes);
                LOGGER.trace("Received message:----\n{}\n----", new String(bytes));
                final SDP2021ProtocolRequest request = SDP2021ProtocolMessageParserExecutor.parse(bytes);
                final String response = request.execute();

                byte[] resposta = new byte[2];
                resposta[Constantes.VERSAO_POS] = Constantes.VERSAO;
                resposta[Constantes.CODE_POS] = Constantes.ENTENDIDO;

                if (response.equalsIgnoreCase("Tarefa")) {
                    List<Byte> tarefa = new ArrayList<>();

                    write(out, resposta);
                    int value = in.read();
                    in.read(bytes, 0, value);

                    write(out, resposta);
                    while (bytes[Constantes.CODE_POS] != 8) {
                        if (bytes[Constantes.CODE_POS] == -1 || bytes[Constantes.CODE_POS] == 7) {
                            for (int i = Constantes.DATA_POS; i < value; i++) {
                                tarefa.add(bytes[i]);
                            }
                        }
                        write(out, resposta);

                        value = in.read();
                        in.read(bytes, 0, value);
                    }

                    byte[] tarefaBytes = new byte[tarefa.size()];
                    int j = 0;
                    for (Byte b : tarefa) {
                        tarefaBytes[j] = b;
                        j++;
                    }
                    ByteArrayInputStream bis = new ByteArrayInputStream(tarefaBytes);
                    ObjectInput input = null;
                    Pedido pedido = null;
                    try {
                        input = new ObjectInputStream(bis);
                        pedido = (Pedido) input.readObject();
                    } finally {
                        try {
                            if (input != null) {
                                input.close();
                            }
                        } catch (IOException ex) {
                            // ignore close exception
                        }
                    }

                    LOGGER.debug("A executar a tarefa automática: " + pedido.fluxoResolucao().tarefaExecucaoResolucao().identity());

//                    ValidarScriptVisitor.run(pedido.getFormulario(),pedido.fluxoResolucao().tarefaExecucaoResolucao().tarefaExecucao().script(),true);
                    ExecutorTarefasAutomaticasDaemon.tarefaExecRes.add(pedido);
                    synchronized (ExecutorTarefasAutomaticasDaemon.algoritmo) {
                        ExecutorTarefasAutomaticasDaemon.algoritmo.notify();
                    }
//                    Pedido finalPedido = pedido;
//                    new Thread(()->{ SendPacket.sendPacketTarefaFalhou(finalPedido);}).start();
//                    sleep(3000);

//
//                    byte[] rep = new byte[3];
//                    rep[Constantes.VERSAO_POS] = Constantes.VERSAO;
//                    rep[Constantes.CODE_POS] = Constantes.TAREFA_TERMINADA;
//                    rep[Constantes.SIZE_POS] = 0;//
//
//                    LOGGER.debug("Fim da Execucao da tarefa " + pedido.fluxoResolucao().tarefaExecucaoResolucao().identity());
//
//                    write(out, rep);
                    break;

                }
                if (request.isGoodbye()) {
                    break;
                }
            }
        }

        private void write(OutputStream out, byte[] resposta) throws IOException {
            out.write(resposta.length);
            out.write(resposta, 0, resposta.length);
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
                new ClientHandler(clientSocket).start(); // recebe tarefa tcp e poe na queue
                System.out.println("ola");
            }
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Wait for connections.
     *
     * @param port
     * @param blocking if {@code true} the socket runs in its own thread.
     */
    public void start(final int port, final boolean blocking) {
        if (blocking) {
            listen(port);
        } else {
            new Thread(() -> listen(port)).start();
        }
    }
}
