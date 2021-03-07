package com.example.demosplinjection.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "manh4495";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


//    public static void main(String[] args) {
//        Connection conn = openConnection();
//        if(conn != null){
//            System.out.println("thanh cong");
//        } else {
//            System.out.println("loi");
//        }
//    }
}
