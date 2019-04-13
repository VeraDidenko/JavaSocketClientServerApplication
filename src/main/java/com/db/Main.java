package com.db;

import java.sql.*;

public class Main {


    private static final String SQL_QUERY_FOR_ALL_GRADES = "SELECT * FROM enrollment E INNER JOIN disciplines P ON P.id = E.discipline_id INNER JOIN student S ON S.id=E.student_id";

    public static void main(String args[]){

        try
        {
            Connection conn = ConnectionToDB.getConnectionToDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL_QUERY_FOR_ALL_GRADES);

            while (rs.next())
            {
                int grade = rs.getInt("grade");
                String disc = rs.getString("name");
                String stud = rs.getString("fio");

                System.out.format("%s, %s, %s\n",  stud, disc, grade);
            }
            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }


    }

}
