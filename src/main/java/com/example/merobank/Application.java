package com.example.merobank;

import com.example.merobank.model.Model;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    public static void main(String[] args) {
        launch();
    }
}