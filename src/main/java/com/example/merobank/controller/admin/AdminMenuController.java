package com.example.merobank.controller.admin;

import com.example.merobank.model.Model;
import com.example.merobank.view.AdminMenuOptions;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {

    @FXML
    private Button clientsButton;

    @FXML
    private Button createAccountButton;

    @FXML
    private Button depositButton;

    @FXML
    private Button logoutButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createAccountButton.setOnAction(event -> onCreateAccountButtonClick());
        clientsButton.setOnAction(event -> onClientsButtonClicked());
        depositButton.setOnAction(event -> onDepositButtonClicked());
    }

    private void onDepositButtonClicked() {
        Model.getInstance().getViewFactory().adminSelectedMenuItemProperty().set(AdminMenuOptions.DEPOSIT);
    }

    private void onClientsButtonClicked() {
        Model.getInstance().getViewFactory().adminSelectedMenuItemProperty().set(AdminMenuOptions.CLIENTS);
    }

    private void onCreateAccountButtonClick() {
        Model.getInstance().getViewFactory().adminSelectedMenuItemProperty().set(AdminMenuOptions.CREATE_CLIENT);
    }
}
