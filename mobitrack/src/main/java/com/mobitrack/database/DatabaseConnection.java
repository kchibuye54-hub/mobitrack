package com.mobitrack.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:sqlite:mobitrack.db";

    public static Connection connect() {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection connection =
                    DriverManager.getConnection(URL);

            System.out.println(
                    "Database Connected");

            return connection;

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());

            return null;
        }
    }
}