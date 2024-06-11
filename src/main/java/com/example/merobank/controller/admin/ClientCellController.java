package com.example.merobank.controller.admin;

import com.example.merobank.model.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {

    @FXML
    private Label checkingAccountLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label payeeAddressLabel;

    @FXML
    private Label savingsAccountLabel;

    public Client client;

    public ClientCellController(Client client) {
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        firstNameLabel.textProperty().bind(client.firstNameProperty());
        lastNameLabel.textProperty().bind(client.lastNameProperty());
        payeeAddressLabel.textProperty().bind(client.payeeAddressProperty());
        savingsAccountLabel.textProperty().bind(client.savingsAccountProperty().asString());
        checkingAccountLabel.textProperty().bind(client.checkingAccountProperty().asString());
        dateLabel.textProperty().bind(client.dateCreatedProperty().asString());
    }
}
