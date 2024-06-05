package com.example.merobank;

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
    public ChoiceBox accountSelectorChoiceBox;
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
        loginButton.setOnAction(e -> onLoginButtonClick());
    }
    private void onLoginButtonClick() {
        Stage stage = (Stage) loginButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeWindow(stage);
        Model.getInstance().getViewFactory().showClientWindow();
    }
}