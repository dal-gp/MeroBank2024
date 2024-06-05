package com.example.merobank;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class DashboardController {
    @FXML
    public Text userNameText;
    @FXML
    public Label dateLabel;
    @FXML
    public Label checkingBalanceLabel;
    @FXML
    public Label checkingAccountNumberLabel;
    @FXML
    public Label incomeLabel;
    @FXML
    public Label expenseLabel;
    @FXML
    public ListView transactionsListView;
    @FXML
    public TextField payeeAddressTextField;
    @FXML
    public TextField amountTextField;
    @FXML
    public TextArea messageTextArea;
    @FXML
    public Button sendMoneyButton;
}
