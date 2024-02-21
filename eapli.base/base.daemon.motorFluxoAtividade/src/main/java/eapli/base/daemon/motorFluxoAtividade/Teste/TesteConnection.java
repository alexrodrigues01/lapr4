package eapli.base.daemon.motorFluxoAtividade.Teste;


import eapli.base.daemon.motorFluxoAtividade.Utils.Constantes;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

import static java.lang.Thread.sleep;

public class TesteConnection {

    public static void main(String args[]) throws Exception {
        doShow();
    }

    public static boolean doShow() throws IOException, InterruptedException {

        InetAddress serverIP = null;
        Socket socket = null;
        String frase;

        System.out.println("Iniciar sessao com o servidor...");

        try {
            serverIP = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        assert serverIP != null;

        System.out.println(serverIP.getHostAddress());

        try {
            socket = new Socket(serverIP, 7879);
        } catch (IOException i) {
            System.out.println("Falha ao conectar");
            System.exit(1);
        }

        DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
        System.out.println("Conectado ao server");

//        Thread serverConn = new Thread(new TcpChatCliConn(socket));
//        serverConn.start();
        byte[] resposta = new byte[300];
        resposta[Constantes.VERSAO_POS] = Constantes.VERSAO;
        resposta[Constantes.CODE_POS] = Constantes.TESTE_REQUEST;

        String received="VAPO VAPO";
        byte [] joaoBytes=received.getBytes(StandardCharsets.UTF_8);
        resposta[Constantes.SIZE_POS]= Integer.valueOf(joaoBytes.length).byteValue();
        System.arraycopy(joaoBytes,0,resposta, Constantes.DATA_POS,joaoBytes.length);

        sOut.write(resposta.length);
        sOut.write(resposta,0,resposta.length);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(new String(resposta));
        DataInputStream in = new DataInputStream(socket.getInputStream());
        int nr=in.read();
        byte[] bytes = new byte[258];
        System.out.println(in.read(bytes,0,nr));
        System.out.println(bytes[0]);
        System.out.println(bytes[1]);
//        serverConn.join();
        socket.close();
        return true;
    }

    static class TcpChatCliConn implements Runnable {
        private Socket s;
        private DataInputStream sIn;

        public TcpChatCliConn(Socket tcp_s) {
            s = tcp_s;
        }

        public void run() {
            int nChars;
            byte[] data = new byte[300];
            String frase;

            try {
                sIn = new DataInputStream(s.getInputStream());
                BufferedReader inn = new BufferedReader(new InputStreamReader(s.getInputStream()));
                while (true) {
                    String string=inn.readLine();
                    System.out.println(string);
                }
            } catch (IOException ex) {
                System.out.println("Cliente desconectado.");
            }
        }
    }
}
