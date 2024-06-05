module com.example.merobank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.merobank to javafx.fxml;
    exports com.example.merobank;
}