package com.example.merobank;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AccountsController {
    @FXML
    public Label checkingAccountNumberLabel;
    @FXML
    public Label transactionLimitLabel;
    @FXML
    public Label checkingAccountDateLabel;
    @FXML
    public Label checkingAccountBalanceLabel;
    @FXML
    public Label savingsAccountNumberLabel;
    @FXML
    public Label withdrawalLimitLabel;
    @FXML
    public Label savingsAccountDateLabel;
    @FXML
    public Label savingsAccountBalanceLabel;
    @FXML
    public TextField amountToSavingsTextField;
    @FXML
    public Button transferToSavingsButton;
    @FXML
    public TextField amountToCheckingTextField;
    @FXML
    public Button transferToCheckingButton;
}
