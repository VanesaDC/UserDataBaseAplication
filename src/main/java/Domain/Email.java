package Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;
    private Email (String email){
        this.email = email;
    }
    public String getString() {
        return email;
    }

    public static Email createEmail (String email) throws DataException{

        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher mather = pattern.matcher(email);
        boolean emailIsNoValid = !mather.find();
        if (emailIsNoValid){
            throw new DataException("El email tiene algún fallo");
        }
        return new Email(email);
    }

}
