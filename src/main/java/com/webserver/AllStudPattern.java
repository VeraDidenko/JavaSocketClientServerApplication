package com.webserver;

public class AllStudPattern {

    public static String header() {
        String header = "";
        header += "HTTP/1.1 200 OK\r\n";
        header += "Content-Type: text/html\r\n\r\n";

        header += "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>All student</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
                "    <style media=\"screen\" type=\"text/css\">\n" +
                "\n" +
                "        body {\n" +
                "\n" +
                "            background-color: rgb(55, 49, 43);\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        h4{\n" +
                "            color:#fffc82;\n" +
                "        }\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\" style=\"text-align: center; margin-top: 80px; \">\n" +
                "\n" +
                "\n" +
                "    <div class=\"row \">\n" +
                "        <div class=\"col-xs-6\">\n" +
                "          <h4>Name</h4>\n" +
                "        </div>\n" +
                "        <div class=\"col-xs-6\">\n" +
                "            <h4>Course</h4>\n" +
                "        </div>\n" +
                "\n" +
                "    </div><br/>\n";

        return header;

    }

    public static String studentInfo(String name, String course) {


        return "<div class=\"row \" style=\"background-color: #fffc82; border-bottom: 1px solid rgb(55, 49, 43);\">\n" +
                "        <div class=\"col-xs-6\"><h4 style=\"color: rgb(55, 49, 43);\">\n" +
                "           " + name + "\n" +
                "        </h4></div>\n" +
                "        <div class=\"col-xs-6\"><h4 style=\"color: rgb(55, 49, 43);\">\n" +
                "      " + course + "\n" +
                "        </h4></div>\n" +
                "    </div>";
    }


    public static String footer() {
        return "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }


}
