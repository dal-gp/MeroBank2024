package com.example.merobank.controller.client;

import com.example.merobank.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    private BorderPane clientParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().clientSelectedItemMenuProperty().addListener((observableValue, s, t1) -> {
            switch(t1) {
                case "Transactions":
                    clientParent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
                    break;
                default:
                    clientParent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
}
