package eapli.base.app.other.console.http;

import ch.qos.logback.core.net.ssl.SSL;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HTTPServerDashboard {
    static private final String BASE_FOLDER = "base.app.other.console\\src\\main\\java\\eapli\\base\\app\\other\\console\\http\\www";
//    static private ServerSocket sock;
    static private final int porta = 8980;

    static final String TRUSTED_STORE = "server.jks";
    static final String KEYSTORE_PASS = "forgotten";

    public static void main(String args[]) throws Exception {
        SSLSocket cliSock;
        tarefasPendentes = 0;
        tarefasPendentesTerminadas = 0;
        closeTerminar = 0;
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS );

        // Use this certificate and private key as server certificate
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);


        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket ssl;
        ssl = (SSLServerSocket) sslF.createServerSocket(porta);
//        try {
//            sock = new ServerSocket(porta);
//        } catch (IOException ex) {
//            System.out.println("Server failed to open local port " + porta);
//            System.exit(1);
//        }
        try {
            while (true) {
                cliSock =(SSLSocket) ssl.accept();
                HttpServerDashboardRequest req = new HttpServerDashboardRequest(cliSock, BASE_FOLDER);
                req.start();
            }
        } catch (IOException ex) {
            System.out.println("Server failed to open local port " + porta);
            System.exit(1);
        }
    }


    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static int tarefasPendentes;
    private static int tarefasPendentesTerminadas;
    private static int closeTerminar;

    public static synchronized String getTarefas() {
        return "<table style=\"width:100%;text-align:center \">\n" +
                "  <tr>\n" +
                "    <th>Estado Tarefa</th>\n" +
                "    <th>Numero de Tarefas</th> \n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Tarefas Pendentes</td>\n" +
                "    <td>" + tarefasPendentes + "</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Tarefas Pendentes Terminadas</td>\n" +
                "    <td>" + tarefasPendentesTerminadas + "</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>Tarefas Pendentes Por Terminar</td>\n" +
                "    <td>" + closeTerminar + "</td>\n" +
                "  </tr>\n" +
                "</table>";
    }

    public static synchronized void setTarefasPendentes(String i) {
        try {
            tarefasPendentes = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
    }

    public static synchronized void setTarefasPendentesTerminadas(String i) {
        try {
            tarefasPendentesTerminadas = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
    }

    public static synchronized void setCloseTerminar(String i) {
        try {
            closeTerminar = Integer.parseInt(i);
        } catch (NumberFormatException ne) {
            return;
        }
    }


}
