package com.example.merobank.controller.client;

import com.example.merobank.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    @FXML
    public Button dashboardButton;
    @FXML
    public Button transactionsButton;
    @FXML
    public Button accountsButton;
    @FXML
    public Button profileButton;
    @FXML
    public Button logoutButton;
    @FXML
    public Button reportButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionsButton.setOnAction(event -> onTransactionsButtonClick());
        dashboardButton.setOnAction(event -> onDashboardButtonClick());
    }

    private void onDashboardButtonClick() {
        Model.getInstance().getViewFactory().clientSelectedItemMenuProperty().set("Dashboard");
    }

    private void onTransactionsButtonClick() {
        Model.getInstance().getViewFactory().clientSelectedItemMenuProperty().set("Transactions");
    }
}
