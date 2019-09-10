package ru.job4j.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * class Client.
 * The client connects to the server and sends him messages.
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.09.2019
 */
public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start(BufferedReader reader) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)) {

            String question = null;
            String response;
            while (!("exit".equals(question))) {
                question = reader.readLine();
                out.println(question);
                response = in.readLine();
                    while (response != null && !response.isEmpty()) {
                        response = in.readLine();
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000)) {
            Client user = new Client(socket);
            user.start(new BufferedReader(new InputStreamReader(System.in)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}