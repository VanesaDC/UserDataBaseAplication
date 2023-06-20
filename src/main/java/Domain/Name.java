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
    public static Name createName(String name) throws NameException{
        boolean nameNotContainsOnlyLetters = !name.matches("[a-zA-Z]*");
        boolean nameIsEmpty = name.isEmpty();
        if (nameIsEmpty){
            throw new NameException("El nombre no puede estar vacío.");
        }
        if (nameNotContainsOnlyLetters){
            throw new NameException("El nombre solo puede contener letras.");
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
