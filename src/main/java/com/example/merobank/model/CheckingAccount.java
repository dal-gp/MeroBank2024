package com.example.merobank.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
    private final IntegerProperty transactionLimit;

    public CheckingAccount(
            String owner, String accountNumber, Double balance,
            int transactionLimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty("", "transactionLimit", transactionLimit);
    }

    public IntegerProperty transactionLimitProperty() {
        return transactionLimit;
    }
}
