package com.qf.project.utile;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
    private static String url = Dutile.getValue("url");
    private static String username = Dutile.getValue("username");
    private static String password = Dutile.getValue("password");
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(Dutile.getValue("driver"));
            return  conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = JDBC.getConnection();
        System.out.println(conn);
    }
}
