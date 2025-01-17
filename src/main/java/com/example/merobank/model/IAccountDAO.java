package com.example.merobank.model;

public interface IAccountDAO {
    public void addCheckingAccount(CheckingAccount account);
    public void addSavingsAccount(SavingsAccount account);
    public CheckingAccount getCheckingAccount(String owner);
    public SavingsAccount getSavingsAccount(String owner);
}
