package com.example.merobank.controller.admin;

import com.example.merobank.model.CheckingAccount;
import com.example.merobank.model.Model;
import com.example.merobank.model.SavingsAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {

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

    private String payeeAddress;
    private boolean createSavingsAccountFlag;
    private boolean createCheckingAccountFlag;

    public void createCheckingAccount() {
        Double balance = Double.parseDouble(checkingAmountBalanceTextField.getText());
        // gen acc num
        String firstSection = "3201";
        String lastSection = Integer.toString((new Random()).nextInt(9999 + 1000));
        System.out.println(lastSection);
        String accountNumber = firstSection + " " + lastSection;
        CheckingAccount checkingAccount = new CheckingAccount(payeeAddress, accountNumber, balance, 10);
        Model.getInstance().createCheckingAccount(checkingAccount);

    }

    public void createSavingsAccount() {
        Double balance = Double.parseDouble(savingsAccountBalanceTextField.getText());
        String firstSection = "3201";
        String lastSection = Integer.toString((new Random()).nextInt(9999 + 1000));
        String accountNumber = firstSection + " " + lastSection;
        SavingsAccount savingsAccount = new SavingsAccount(payeeAddress, accountNumber, balance, 2000.0);
        Model.getInstance().createSavingsAccount(savingsAccount);
    }

    public void createClient() {
        if(createCheckingAccountFlag) {
            createCheckingAccount();
        }
        if(createSavingsAccountFlag) {
            createSavingsAccount();
        }

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String password = passwordTextField.getText();
        Model.getInstance().createClient(firstName, lastName, payeeAddress, password, LocalDate.now());
        errorLabel.setStyle("-fx-text-fill: blue; fx-font-size: 1.3em; -fx-font-weight: bold");
        errorLabel.setText("Client Created Successfully!");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        passwordTextField.setText("");
        payeeAddressLabel.setText("");
        payeeAddressCheckBox.setSelected(false);
        checkingAccountCheckBox.setSelected(false);
        savingsAccountCheckBox.setSelected(false);
        checkingAmountBalanceTextField.setText("");
        savingsAccountBalanceTextField.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createNewClientButton.setOnAction(event -> createClient());
        payeeAddressCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) {
                String payeeAddress = createPayeeAddress();
                if(firstNameTextField.getText() != null && lastNameTextField.getText() != null) {
                    payeeAddressLabel.setText(payeeAddress);
                    this.payeeAddress = payeeAddress;
                }
            }
        });
        checkingAccountCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) {
                createCheckingAccountFlag = true;
            }
        });
        savingsAccountCheckBox.selectedProperty().addListener((observableValue, aBoolean, t1) -> {
            if(t1) {
                createSavingsAccountFlag = true;
            }
        });
    }

    private String createPayeeAddress() {
        int id = Model.getInstance().getLastClientsId() + 1;
        char fChar = Character.toLowerCase(firstNameTextField.getText().charAt(0));
        return "@" + fChar + lastNameTextField.getText() + id;
    }
}
