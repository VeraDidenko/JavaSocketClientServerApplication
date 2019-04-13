package com.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HttpServer {

    private final Integer port = 8000;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.runServer();
    }

    private void runServer() {

        try {


            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Started on port: " + port);

            while (true) {
                System.out.println("Accepting on port: " + port);

                Socket socket = serverSocket.accept();

                new Thread(new ConnectionHandler(socket)).start();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
