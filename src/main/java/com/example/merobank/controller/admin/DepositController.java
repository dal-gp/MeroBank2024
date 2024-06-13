package com.example.merobank.controller.admin;

import com.example.merobank.model.Client;
import com.example.merobank.model.Model;
import com.example.merobank.view.ClientCellFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositController implements Initializable {

    @FXML
    private TextField amountTextField;

    @FXML
    private Button depositButton;

    @FXML
    private TextField payeeAddressTextField;

    @FXML
    private ListView<Client> resultsListView;

    @FXML
    private Button searchButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchButton.setOnAction(e -> onSearchButtonClick());

        depositButton.setOnAction(e -> onDepositButtonClick());
    }

    private void onDepositButtonClick() {
        Double amt = Double.parseDouble(amountTextField.getText());
        double newBal = amt + client.getSavingsAccount().balanceProperty().get();
        if(amountTextField != null) {
            Model.getInstance().depositSavings(client.getPayeeAddress(), newBal);
        }
        payeeAddressTextField.clear();
        amountTextField.clear();
    }

    private Client client = null;

    private void onSearchButtonClick() {
        ObservableList<Client> result = Model.getInstance().searchClient(payeeAddressTextField.getText());
        resultsListView.setItems(result);
        resultsListView.setCellFactory(clientListView -> new ClientCellFactory());
        client = result.get(0);
    }
}
