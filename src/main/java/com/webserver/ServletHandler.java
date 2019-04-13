package com.webserver;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

class ServletHandler {


    private String servletName;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    ServletHandler(String servletName, HttpRequest request, HttpResponse response) {
        this.servletName = servletName;
        this.httpRequest = request;
        this.httpResponse = response;
        handleServlet();
    }

    private void handleServlet() {
        try {

            URL[] classLoaderUrls = new URL[]{new URL("file:/D:/spring-security-demo-starter/spring-security-demo-starter/ORM Practice/src/main/java/com")};

            URLClassLoader loader = new URLClassLoader(classLoaderUrls);
            servletName = servletName.replace("?","");

            Class servlet = loader.loadClass("com.webserver."+servletName);

           Servlet servletInstance = (Servlet) servlet.newInstance();

           servletInstance.init();
           servletInstance.service(httpRequest, httpResponse);
           servletInstance.destroy();

        }  catch (ClassNotFoundException | IllegalAccessException | InstantiationException | MalformedURLException e) {
            e.printStackTrace();
        }


    }


}
