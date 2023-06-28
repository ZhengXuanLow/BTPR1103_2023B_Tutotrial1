module com.example.tutorial1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tutorial1 to javafx.fxml;
    exports com.example.tutorial1;
}