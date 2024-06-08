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
}
