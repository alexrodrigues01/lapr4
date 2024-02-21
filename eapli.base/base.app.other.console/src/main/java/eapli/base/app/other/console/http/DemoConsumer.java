package eapli.base.app.other.console.http;

import java.io.*;
import java.net.*;

/**
 * @author asc@isep.ipp.pt
 */
public class DemoConsumer {
    static private Socket sock;
    static private InetAddress serverIP;
    static private int serverPort = 8989;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;
    static private String ip = "localhost";

    // THE NUMBER OF VOTES TO CAST ON THE FIRST CANDIDATE
    static private final int VOTES_TO_CAST = 200;

    public static void main(String args[]) throws Exception {

        try {
            serverIP = InetAddress.getByName(ip);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.exit(1);
        }

        HTTPmessage request = new HTTPmessage();
        request.setRequestMethod("PUT");
        request.setURI("/closeTerminar/5");

        sock = new Socket(serverIP, serverPort);

        sOut = new DataOutputStream(sock.getOutputStream());

        sIn = new DataInputStream(sock.getInputStream());

        request.send(sOut);

        HTTPmessage response= new HTTPmessage(sIn);

        System.out.println(response.getStatus());

    }
} // CLASS
    
