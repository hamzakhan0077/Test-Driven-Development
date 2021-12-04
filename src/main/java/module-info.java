module com.example.javaasg3v11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javaasg3v11 to javafx.fxml;
    exports com.example.javaasg3v11;
}