package com.example.merobank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqliteAccountDAO implements IAccountDAO{
    private Connection connection;

    public SqliteAccountDAO() {
        connection = SqliteConnection.getInstance();
    }
    @Override
    public void addCheckingAccount(CheckingAccount account) {
        try {
            String query = "INSERT INTO checking_accounts (owner, account_number, transaction_limit, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.ownerProperty().get());
            preparedStatement.setString(2, account.accountNumberProperty().get());
            preparedStatement.setInt(3, account.transactionLimitProperty().get());
            preparedStatement.setDouble(4, account.balanceProperty().get());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void addSavingsAccount(SavingsAccount account) {

        try {
            String query = "INSERT INTO savings_accounts (owner, account_number, withdrawal_limit, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, account.ownerProperty().get());
            preparedStatement.setString(2, account.accountNumberProperty().get());
            preparedStatement.setDouble(3, account.getWithdrawal_limitProperty().get());
            preparedStatement.setDouble(4, account.balanceProperty().get());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public CheckingAccount getCheckingAccount(String owner) {
        CheckingAccount checkingAccount;
        try {
            String query = "SELECT * FROM checking_accounts WHERE owner = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String accNum = resultSet.getString("account_number");
                int tranLimit = resultSet.getInt("transaction_limit");
                double bal = resultSet.getDouble("balance");
                checkingAccount = new CheckingAccount(owner, accNum, bal, tranLimit) ;
                return checkingAccount;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SavingsAccount getSavingsAccount(String owner) {

        SavingsAccount savingsAccount;
        try {
            String query = "SELECT * FROM savings_accounts WHERE owner = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, owner);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String accNum = resultSet.getString("account_number");
                double wLimit = resultSet.getDouble("withdrawal_limit");
                double bal = resultSet.getDouble("balance");
                savingsAccount = new SavingsAccount(owner, accNum, bal, wLimit);
                return savingsAccount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // better to move this one to AccountManager class
    // need id field
//    public void updateSavingsAccount(SavingsAccount account) {
//        try {
//            String query = "UPDATE savings_account SET owner = ?, account_number = ?, withdrawal_limit = ?, balance = ? WHERE id = ?";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, account.ownerProperty().get());
//            preparedStatement.setString(2, account.accountNumberProperty().get());
//            preparedStatement.setDouble(3, account.getWithdrawal_limitProperty().get());
//            preparedStatement.setDouble(4, account.balanceProperty().get());
//            preparedStatement.setInt(5, account.);
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    public void updateSavingsAccount(String payeeAddress, double balance) {
        try {
            String query = "UPDATE savings_accounts SET balance = ? WHERE owner = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, balance);
            preparedStatement.setString(2, payeeAddress);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
