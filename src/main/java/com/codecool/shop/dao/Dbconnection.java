package com.codecool.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
    static final String url = "jdbc:postgresql://localhost:5432/codecoolshop";

    //  Database credentials
    private final String user = "milan";
    private final String password = "Mzt11qhR6l5K";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        Dbconnection myapp = new Dbconnection();
        myapp.connect();
    }

}
