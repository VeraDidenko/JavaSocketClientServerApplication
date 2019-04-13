package com.db;

import java.sql.*;

public class ConnectionToDB {


    private static final String DBURL = "jdbc:mysql://localhost/universityDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DBUser = "root";
    private static final String DBUserPassword="26011998mhcftL!";


    public static Connection getConnectionToDB() throws DAOException{
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DBURL,DBUser,DBUserPassword);
            if(connection!=null) {
                return connection;
            }else {
                throw new DAOException();
            }
        }catch(Exception e) {
            throw new DAOException();
        }

    }

}
