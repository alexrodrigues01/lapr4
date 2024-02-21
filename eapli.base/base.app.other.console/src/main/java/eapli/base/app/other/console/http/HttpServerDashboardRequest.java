package eapli.base.app.other.console.http;

import javax.net.ssl.SSLSocket;
import java.io.*;

/**
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerDashboardRequest extends Thread {
    String baseFolder;
    SSLSocket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HttpServerDashboardRequest(SSLSocket s, String f) {
        baseFolder = f;
        sock = s;
    }

    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex) {
            System.out.println("Thread error on data streams creation");
        }
        try {
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();
            // System.out.println(request.getURI());

            if (request.getMethod().equals("GET")) {
                if (request.getURI().equals("/tarefas")) {
                    response.setContentFromString(
                            HTTPServerDashboard.getTarefas(), "text/html");
                    response.setResponseStatus("200 Ok");
                } else {
                    String fullname = baseFolder + "/";
                    if (request.getURI().equals("/")) fullname = fullname + "index.html";
                    else fullname = fullname + request.getURI();
                    if (response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        response.setContentFromString(
                                "<html><body><h1>404 File not found</h1></body></html>",
                                "text/html");
                        response.setResponseStatus("404 Not Found");
                    }
                }
                response.send(outS);
            } else { // NOT GET
                if (request.getMethod().equals("PUT")) {
                    if (request.getURI().startsWith("/tarefasPendentes/")) {
                        HTTPServerDashboard.setTarefasPendentes(request.getURI().substring(18));
                        response.setResponseStatus("200 Ok");
                    } else {
                        if (request.getURI().startsWith("/tarefasPendentesTerminadas/")) {
                            HTTPServerDashboard.setTarefasPendentesTerminadas(request.getURI().substring(28));
                            response.setResponseStatus("200 Ok");
                        } else if (request.getURI().startsWith("/closeTerminar/")) {
                            HTTPServerDashboard.setCloseTerminar(request.getURI().substring(15));
                            response.setResponseStatus("200 Ok");
                        } else {
                            response.setContentFromString(
                                    "<html><body><h1>ERROR: 405 Method Not Allowed</h1></body></html>",
                                    "text/html");
                            response.setResponseStatus("405 Method Not Allowed");
                        }
                    }
                }
                response.send(outS);
            }
        } catch (IOException ex) {
            System.out.println("Thread error when reading request: "+ ex.getMessage());
        }
        try {
            sock.close();
        } catch (IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }
}

