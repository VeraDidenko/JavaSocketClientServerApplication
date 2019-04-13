package com.webserver;


import java.io.UnsupportedEncodingException;

public class StudentInfo implements Servlet {

    @Override
    public void init() {
        System.out.println("[INFO] Servlet was initiated");
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {


        if(request.getMethodCall().equalsIgnoreCase("post")){
            StudentInfoImpl studentInfo = new StudentInfoImpl();
            try {
                studentInfo.doPost(request,response);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if(request.getMethodCall().equalsIgnoreCase("get")){
            StudentInfoImpl studentInfo = new StudentInfoImpl();
            studentInfo.doGet(request,response);
        }

    }

    @Override
    public void destroy()  {
        System.out.println("[INFO] Servlet was destroyed");
    }
}
