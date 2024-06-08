package com.example.merobank.model;

import org.sqlite.SQLiteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteAdminDAO implements IAdminDAO {
    private Connection connection;

    public SqliteAdminDAO() {
        connection = SqliteConnection.getInstance();
    }
    @Override
    public Admin getAdmin(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String un = resultSet.getString("username");
                String pw = resultSet.getString("password");
                return new Admin(un, pw);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
