package com.UI;

import javafx.scene.control.Alert;

public class AlertPanel {
    public static void showAttentionMessageSaying(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Atención");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void showInformationMessageSaying(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Ok");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
