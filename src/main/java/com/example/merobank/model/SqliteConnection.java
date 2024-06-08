package com.example.merobank.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnection {
    private static Connection instance = null;

    private SqliteConnection () {
        try {
            instance = DriverManager.getConnection("jdbc:sqlite:merobank.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if(instance == null) {
            new SqliteConnection();
        }
        return instance;
    }
}
