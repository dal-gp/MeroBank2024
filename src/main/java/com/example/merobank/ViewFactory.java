package com.example.merobank;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    public ViewFactory() {
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/merobank/client.fxml"));
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

    public void closeWindow(Stage stage) {
        stage.close();
    }
}