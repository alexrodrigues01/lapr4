/*
 * Copyright (c) 2013-2019 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.common.console.presentation.authz;

import eapli.framework.infrastructure.authz.application.AuthenticationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * UI for user login action. Created by nuno on 21/03/16.
 */
@SuppressWarnings("squid:S106")
public class LoginUI extends AbstractUI {

    private final AuthenticationService authenticationService = AuthzRegistry.authenticationService();

    private Role onlyWithThis;
    private static final int DEFAULT_MAX_ATTEMPTS = 3;
    private final int maxAttempts;
    private static final int PORT = 7475;
    static private String ip = "10.8.0.80";
    private String fix= "fix";

    public LoginUI() {
        maxAttempts = DEFAULT_MAX_ATTEMPTS;
    }

    public LoginUI(final Role onlyWithThis) {
        this.onlyWithThis = onlyWithThis;
        maxAttempts = DEFAULT_MAX_ATTEMPTS;
    }

    public LoginUI(final Role onlyWithThis, final int maxAttempts) {
        this.onlyWithThis = onlyWithThis;
        this.maxAttempts = maxAttempts;
    }

    public LoginUI(final int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    protected boolean doShow() {
        int attempt = 1;
        while (attempt <= maxAttempts) {
            final String userName = Console.readLine("Username:");
            final String password = Console.readLine("Password:");

            if (authenticationService.authenticate(userName, password, onlyWithThis).isPresent()) {
                String email = AuthzRegistry.authorizationService().session().get().authenticatedUser().email().toString();
                try {
                    informarMotorFluxo(email);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            } else {
                System.out.printf("Wrong username or password. You have %d attempts left.%n%n»»»»»»»»»%n",
                        maxAttempts - attempt);
            }
            attempt++;
        }
        System.out.println("Sorry, we are unable to authenticate you. Please contact your system admnistrator.");
        return false;
    }

    static final String KEYSTORE_PASS = "forgotten";

    private void informarMotorFluxo(String email) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", "server.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", "server.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASS);

        InetAddress serverIP = null;
        Socket socket = null;
        String frase;
        try {
            serverIP = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        assert serverIP != null;

        System.out.println(serverIP.getHostAddress());
        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            socket = (SSLSocket) sf.createSocket(serverIP, PORT);
        } catch (IOException i) {
            System.out.println("Falha ao conectar");
            System.exit(1);
        }

        try {
            ((SSLSocket) socket).startHandshake();
        } catch (NullPointerException | IOException n) {
            System.out.println("Erro");
        }

        DataOutputStream sOut = new DataOutputStream(socket.getOutputStream());
        System.out.println("Conectado ao server");
        byte[] emailBytes = email.getBytes(StandardCharsets.UTF_8);
        byte[] resposta = new byte[124];
        resposta[0] = 0;
        resposta[1] = 9;

        resposta[2] = (byte) emailBytes.length;

        for (int i = 3, j = 0; j < emailBytes.length; i++, j++) {
            resposta[i] = emailBytes[j];
        }
        sOut.write((byte) resposta.length);
        sOut.write(resposta, 0, (byte) resposta.length);

        DataInputStream sin = new DataInputStream(socket.getInputStream());

        int nr = sin.read();
        sin.read(resposta, 0, nr);
        System.out.println("Email enviado para o motor");
    }


    @Override
    public String headline() {
        return "Login";
    }
}
