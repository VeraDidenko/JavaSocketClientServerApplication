package com.webserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

class HttpResponse {

    private final HttpRequest httpRequest;
    private String response;
    private final static String rootPath = "web/pages/";

    HttpResponse(HttpRequest httpRequest) {

        this.httpRequest = httpRequest;
        createResponse();

    }


    private void createResponse() {

        try {
            String path = httpRequest.getPathToFile();


            if (path.contains("servlet")) {

                new ServletHandler(path.substring(path.lastIndexOf("/") + 1), httpRequest, this);

            } else {

                if (path.equals("/")) {
                    path = "index.html";
                }


                File responseFile = new File(rootPath, path);


                FileInputStream responseFileInputStream = new FileInputStream(responseFile);


                String responseHeader = "";

                responseHeader += "HTTP/1.1 200 OK\r\n";
                responseHeader += "Content-Type: text/html\r\n\r\n";

                response = responseHeader;


                int s;

                while ((s = responseFileInputStream.read()) != -1) {
                    response += (char) s;
                }

            }


        } catch (FileNotFoundException e) {
            response = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
        } catch (IOException e) {
            response = "HTTP/1.1 500\r\n" +
                    "Content-Type: text/html\r\n" +
                    "\r\n";
        }


    }

    String getResponse() {
        return response;
    }

    void setResponse(String response) {
        this.response = response;
    }
}
