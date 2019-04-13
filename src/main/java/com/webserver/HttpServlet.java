package com.webserver;

import java.io.UnsupportedEncodingException;

public interface HttpServlet {

    HttpResponse doPost(HttpRequest request, HttpResponse response) throws UnsupportedEncodingException;
    HttpResponse doGet(HttpRequest request, HttpResponse response);

}
