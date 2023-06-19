package com.example.mysqlfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Properties datasConfig = new Properties();

        try {
            datasConfig.load(new FileInputStream("dataConnection.properties"));
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                        datasConfig.getProperty("url") +
                            datasConfig.getProperty("database"),
                            datasConfig.getProperty("user"),
                            datasConfig.getProperty("password"));
            Statement st;
            ResultSet rs;
            st = con.createStatement();
            rs = st.executeQuery("Select * from alumnos");
            while (rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        launch();
    }
}