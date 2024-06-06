package com.example.merobank.controller.admin;

import com.example.merobank.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private BorderPane adminParent;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().adminSelectedMenuItemProperty()
                .addListener((observableValue, s, t1) -> {
                    switch(t1) {
                        case CLIENTS:
                            adminParent.setCenter(Model.getInstance().getViewFactory().getClientsView());
                            break;
                        default:
                            adminParent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
                    }
                });
    }
}
