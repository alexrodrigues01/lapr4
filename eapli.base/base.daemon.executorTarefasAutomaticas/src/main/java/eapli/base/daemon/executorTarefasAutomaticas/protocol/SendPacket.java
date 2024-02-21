package eapli.base.daemon.executorTarefasAutomaticas.protocol;

import eapli.base.daemon.executorTarefasAutomaticas.utils.Constantes;
import eapli.base.servicomanagement.domain.Pedido;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SendPacket {

    private static final Logger LOGGER = LogManager.getLogger(SendPacket.class);
    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "forgotten";

    public static void sendPacketTarefaFalhou(Pedido pedido) {
        LOGGER.info("INICIO DO SEND PACKET");
        Socket socket=null;
        try {
            System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key as server certificate
            System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            InetAddress serverIP = null;
             socket = null;

            LOGGER.info("Iniciar sessao com o servidor...");

            serverIP = InetAddress.getByName(Constantes.IP_MOTOR);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            assert serverIP != null;
            int attempt = 0;
            LOGGER.warn(serverIP.getHostAddress());

            while (true) {
                try {
                    attempt++;
                    socket = (SSLSocket) sf.createSocket(serverIP, 7475);
                    break;
                } catch (IOException i) {
                    if (attempt == 3) {
                        LOGGER.warn("Connection Failed!!");
                        throw new Exception("Falha a conectar");
                    }
                    LOGGER.warn("Watting 30 seconds to try a new connection! ");
                    LOGGER.warn("Attempt " + attempt);
                    System.out.println();
                }
            }

            ((SSLSocket) socket).startHandshake();

            DataInputStream in = new DataInputStream(socket.getInputStream());

            DataOutputStream outt = new DataOutputStream(socket.getOutputStream());

            byte[] idbyte=pedido.identity().getBytes(StandardCharsets.UTF_8);
            int size=idbyte.length;

            byte[] copy2 = new byte[size + 3];
            for (int i = 0; i < size; i++) {
                copy2[i + 3] = idbyte[i];
            }

            copy2[Constantes.VERSAO_POS] = Constantes.VERSAO;
            copy2[Constantes.CODE_POS] = Integer.valueOf(Constantes.TAREFA_FALHOU).byteValue();
            copy2[Constantes.SIZE_POS] = Integer.valueOf(size).byteValue(); // 255

            outt.write((byte) copy2.length);
            outt.write(copy2, 0, (byte) copy2.length);

            int nr = in.read();
            byte [] resposta = new byte[nr];
            in.read(resposta, 0, nr);
            socket.close();

            socket.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
        LOGGER.info("FIM DO SEND PACKET");
    }

    public static void sendPacketTarefaTerminou(Pedido pedido) {
        Socket socket=null;
        LOGGER.info("INICIO DO SEND PACKET");
        try {
            System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key as server certificate
            System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

            InetAddress serverIP = null;
             socket = null;

            LOGGER.info("Iniciar sessao com o servidor...");

            serverIP = InetAddress.getByName(Constantes.IP_MOTOR);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
            assert serverIP != null;
            int attempt = 0;
            LOGGER.warn(serverIP.getHostAddress());

            while (true) {
                try {
                    attempt++;
                    socket = (SSLSocket) sf.createSocket(serverIP, 7475);
                    break;
                } catch (IOException i) {
                    if (attempt == 3) {
                        LOGGER.warn("Connection Failed!!");
                        throw new Exception("Falha a conectar");
                    }
                    LOGGER.warn("Watting 30 seconds to try a new connection! ");
                    LOGGER.warn("Attempt " + attempt);
                    System.out.println();
                }
            }

            ((SSLSocket) socket).startHandshake();

            DataInputStream in = new DataInputStream(socket.getInputStream());

            DataOutputStream outt = new DataOutputStream(socket.getOutputStream());

            byte[] idbyte=pedido.identity().getBytes(StandardCharsets.UTF_8);
            int size=idbyte.length;

            byte[] copy2 = new byte[size + 3];
            for (int i = 0; i < size; i++) {
                copy2[i + 3] = idbyte[i];
            }

            copy2[Constantes.VERSAO_POS] = Constantes.VERSAO;
            copy2[Constantes.CODE_POS] = Integer.valueOf(Constantes.TAREFA_TERMINADA).byteValue();
            copy2[Constantes.SIZE_POS] = Integer.valueOf(size).byteValue(); // 255

            outt.write((byte) copy2.length);
            outt.write(copy2, 0, (byte) copy2.length);

            int nr = in.read();
            byte [] resposta = new byte[nr];
            in.read(resposta, 0, nr);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
            LOGGER.info("Socket Fechada");
        }
        LOGGER.info("FIM DO SEND PACKET");
    }
}
