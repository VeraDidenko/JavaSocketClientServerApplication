package com.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ConnectionHandler implements Runnable {

    private PrintWriter out;
    private BufferedReader in;

    private final Socket socket;

    ConnectionHandler(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }


    @Override
    public void run() {


        try {
            StringBuilder request = new StringBuilder();

            while (in.ready()) {
                request.append((char) in.read());
            }


            System.out.println(request);

            HttpRequest httpRequest = new HttpRequest(request.toString(), socket.getLocalAddress().getHostAddress());

            HttpResponse httpResponse = new HttpResponse(httpRequest);

            out.println(httpResponse.getResponse());

            out.flush();

            out.close();
            in.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
