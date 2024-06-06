package com.example.merobank.controller.client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TransactionCellController {

    @FXML
    private Label amountLabel;

    @FXML
    private FontAwesomeIconView inIcon;

    @FXML
    private FontAwesomeIconView outIcon;

    @FXML
    private Label receiverLabel;

    @FXML
    private Label senderLabel;

    @FXML
    private Label transactionDateLabel;

}
