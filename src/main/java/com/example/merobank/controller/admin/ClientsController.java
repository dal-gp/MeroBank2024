package com.example.merobank.controller.admin;

import com.example.merobank.model.Client;
import com.example.merobank.model.Model;
import com.example.merobank.view.ClientCellFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {

    @FXML
    private ListView<Client> clientsListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClients();
            System.out.println("isEmpty");
        }
        clientsListView.setItems(Model.getInstance().getClients());
        System.out.println("DD");
        clientsListView.setCellFactory(clientListView -> new ClientCellFactory());
    }
}
