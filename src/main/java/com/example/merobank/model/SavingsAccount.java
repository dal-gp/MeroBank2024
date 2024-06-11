package com.example.merobank.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account {
    private final DoubleProperty withdrawal_limit;
    public SavingsAccount(String owner, String accountNumber, Double balance,
                          Double withdrawal_limit) {
        super(owner, accountNumber, balance);
        this.withdrawal_limit = new SimpleDoubleProperty(
                this, "withdrawal_limit", withdrawal_limit);
    }

    public DoubleProperty getWithdrawal_limitProperty() {
        return withdrawal_limit;
    }

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }
}
