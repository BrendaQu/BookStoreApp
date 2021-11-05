package com.fhw.ProjectBookstore;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        if (connection == null) {

            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bookstore", "fhw", "12345");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }
}

