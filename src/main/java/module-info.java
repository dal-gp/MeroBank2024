module com.example.merobank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.merobank to javafx.fxml;
    exports com.example.merobank;
    exports com.example.merobank.controller.client;
    opens com.example.merobank.controller.client to javafx.fxml;
    exports com.example.merobank.model;
    opens com.example.merobank.model to javafx.fxml;
    exports com.example.merobank.view;
    opens com.example.merobank.view to javafx.fxml;
    exports com.example.merobank.controller;
    opens com.example.merobank.controller to javafx.fxml;
    exports com.example.merobank.controller.admin;
    opens com.example.merobank.controller.admin to javafx.fxml;
}