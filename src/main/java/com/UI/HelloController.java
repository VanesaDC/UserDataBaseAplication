package com.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondWindow.fxml"));
        try {
            Parent root = loader.load();
            SecondWindowController controller = loader.getController();
            Scene scene = new Scene(root,500,500);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        welcomeText.setText("Welcome to JavaFX Application!");
    }
}