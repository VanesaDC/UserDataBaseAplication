module com.example.mysqlfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.mysqlfx to javafx.fxml;
    exports com.example.mysqlfx;
}