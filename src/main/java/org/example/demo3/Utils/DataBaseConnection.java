package org.example.demo3.Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    private static DataBaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3308/etudiant_db";
    private final String username = "root";
    private final String password = "";



    private DataBaseConnection() {
        try {
            System.out.println("Loading Driver...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            System.out.println("Connecting to db...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully connected to db...");
        } catch (Exception e) {
            System.out.println("Failed to connect to database! " + e.getMessage());
        }
    }

    public static DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }




}
