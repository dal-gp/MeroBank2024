package com.example.merobank.view;

import com.example.merobank.controller.admin.AdminController;
import com.example.merobank.controller.client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private final ObjectProperty<ClientMenuOptions> clientSelectedItemMenu;
    private AnchorPane transactionsView;
    private AnchorPane dashboardView;

    private AccountType loginAccountType;

    public ViewFactory() {
        clientSelectedItemMenu = new SimpleObjectProperty<>();
        this.loginAccountType = AccountType.CLIENT;
    }

    public ObjectProperty<ClientMenuOptions> clientSelectedItemMenuProperty() {
        return clientSelectedItemMenu;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public void showLoginWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/merobank/login.fxml"));
        Scene scene  = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void showClientWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/merobank/client/client.fxml"));
        // Must set the controller
        ClientController clientController = new ClientController();
        fxmlLoader.setController(clientController);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void showAdminWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/merobank/admin/admin.fxml"));
        // Must have pre-constructed controller
        // since we have not specified any on admin.fxml
        AdminController controller = new AdminController();
        fxmlLoader.setController(controller);

        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeWindow(Stage stage) {
        stage.close();
    }

    public AnchorPane getTransactionsView() {
        if(transactionsView == null) {
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/com/example/merobank/client/transactions.fxml")).load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return transactionsView;
    }

    public AnchorPane getDashboardView() {
        if(dashboardView == null) {
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/com/example/merobank/client/dashboard.fxml")).load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }
}