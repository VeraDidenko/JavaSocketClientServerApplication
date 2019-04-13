package com.webserver;

class HttpRequest {


    private String pathToFile;

    private String methodCall;

    private String request;

    private String localAdress;

    HttpRequest(String request, String localAdress) {
        this.request = request;
        this.localAdress = localAdress;
        parseRequest(request);
    }

    private void parseRequest(String request) {

        int beginIndex = request.indexOf(" ");
        int endIndex = request.indexOf("HTTP");

        methodCall = (beginIndex != -1) ? request.substring(0, beginIndex) : "";

        pathToFile = (beginIndex != -1 && endIndex != -1) ? request.substring(beginIndex, endIndex).trim() : "";

    }

    String getPathToFile() {
        return pathToFile;
    }

    String getMethodCall() {
        return methodCall;
    }

    String getRequest() {
        return request;
    }

    public String getLocalAdress() {
        return localAdress;
    }


}
