package ru.job4j.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * class Server.
 * The server answers simple questions. If the server receives the message "exit",
 * then the application terminates.
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.09.2019
 */
public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            String ask = null;
            while (!("exit".equals(ask))) {
                System.out.println("Wait command...");
                ask = in.readLine();
                System.out.println(ask);
                if ("Hello oracle".equals(ask)) {
                    out.println("Hello, dear friend, I'm Oracle.");
                    out.println();
                } else if (!("exit".equals(ask))) {
                    out.println("I don't understand.");
                    out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}