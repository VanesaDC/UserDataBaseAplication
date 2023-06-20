package Domain;

import javafx.scene.control.Alert;

public class Name {
    private String name;
    private Name(String name){
        this.name = name;
    }
    public String getName (){
        return name;
    }
    public static Name createName(String name){
        boolean nameNotContainsOnlyLetters = !name.matches("[a-zA-Z]*");
        boolean nameIsEmpty = name.isEmpty();
        if (nameIsEmpty){

            showAttentionMessageSaying("El nombre no puede estar vacío.");

        }
        if (nameNotContainsOnlyLetters){
            showAttentionMessageSaying("El nombre solo puede contener letras.");
            return null;
        }
        return new Name(name);
    }

    private static void showAttentionMessageSaying(String message) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("atención");
        alert.setContentText(message);
        alert.showAndWait();
    }


}
