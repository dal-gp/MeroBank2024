package com.example.merobank.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqliteClientDAO implements IClientDAO{
    private Connection connection;

    public SqliteClientDAO() {
        this.connection = SqliteConnection.getInstance();
    }

    @Override
    public Client getClient(String payeeAddress, String password) {
        // required otherwise throws an exception
        Client client = new Client("","","",null, null, null);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE payee_address = ? AND password = ?");
            preparedStatement.setString(1, payeeAddress);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                client.firstNameProperty().set(resultSet.getString("first_name"));
                client.lastNameProperty().set(resultSet.getString("last_name"));
                client.payeeAddressProperty().set(resultSet.getString("payee_address"));
                String[] dateParts = resultSet.getString("date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                client.dateCreatedProperty().set(date);
                return client;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addClient(String firstName, String lastName, String payeeAddress, String password, LocalDate date) {
        String query = "INSERT INTO clients (first_name, last_name, payee_address, password, date) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, payeeAddress);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, date.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getClientsLastId() {
        int id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name = 'clients'");
            id = resultSet.getInt("seq");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }


}
