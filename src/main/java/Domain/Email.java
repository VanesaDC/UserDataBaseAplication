package Domain;

import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;
    private Email (String email){
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public static Email createEmail (String email) throws EmailException{

            Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
            Matcher mather = pattern.matcher(email);
            boolean emailIsNoValid = !mather.find();
            if (emailIsNoValid){
                throw new EmailException("Error: El email tiene algún fallo");
            }
        return new Email(email);
    }
    public static void showAttentionMessageSaying(String message) {
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("atención");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
