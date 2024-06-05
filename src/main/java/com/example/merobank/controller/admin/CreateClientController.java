package com.example.merobank.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateClientController {

    @FXML
    private CheckBox checkingAccountCheckBox;

    @FXML
    private TextField checkingAmountBalanceTextField;

    @FXML
    private Button createNewClientButton;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private CheckBox payeeAddressCheckBox;

    @FXML
    private Label payeeAddressLabel;

    @FXML
    private TextField savingsAccountBalanceTextField;

    @FXML
    private CheckBox savingsAccountCheckBox;

}
