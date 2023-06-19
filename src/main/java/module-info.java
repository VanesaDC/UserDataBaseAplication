module com.example.mysqlfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.mysqlfx to javafx.fxml;
    exports com.example.mysqlfx;
}