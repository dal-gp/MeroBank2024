package com.example.merobank.controller;

import com.example.merobank.model.Model;
import com.example.merobank.view.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public ChoiceBox<AccountType> accountSelectorChoiceBox;
    @FXML
    public Label payeeAddressLabel;
    @FXML
    public TextField payeeAddressTextBox;
    @FXML
    public TextField passwordTextBox;
    @FXML
    public Button loginButton;
    @FXML
    public Label errorLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountSelectorChoiceBox.setItems(FXCollections.observableArrayList(AccountType.ADMIN, AccountType.CLIENT));
        accountSelectorChoiceBox.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        accountSelectorChoiceBox.valueProperty().addListener(observable -> {
            Model.getInstance().getViewFactory().setLoginAccountType(accountSelectorChoiceBox.getValue());
        });
        loginButton.setOnAction(e -> onLoginButtonClick());
    }
    private void onLoginButtonClick() {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeWindow(stage);

        if(Model.getInstance().getViewFactory().getLoginAccountType() == AccountType.CLIENT){
            Model.getInstance().getViewFactory().showClientWindow();
        } else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }
    }
}