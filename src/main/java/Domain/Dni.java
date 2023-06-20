package Domain;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Dni {

    private String dni;

    public Dni(String dni) {
        this.dni = dni;
    }

    public static Dni createDni (String dni) throws DniException{
        final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
        final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };
        boolean isValid=  Arrays.binarySearch(INVALIDOS, dni) < 0 //(1)
                && REGEXP.matcher(dni).matches() // (2)
                && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3);
        if (!isValid){

        }
        return new Dni(dni);
    }


}
