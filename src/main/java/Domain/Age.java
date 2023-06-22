package Domain;

import java.util.regex.Pattern;

public class Age {
    private final String age;

    private Age(String age) {
        this.age = age;
    }

    public String getString() {
        return age;
    }

    public static Age createAge(String number) throws DataException {
        Pattern patron = Pattern.compile("[0-9]+");
        boolean notIsNumeric = !(patron.matcher(number).find());
        if (notIsNumeric) {
            throw new DataException("Escriba la edad con números, por favor.");
        }
        int age = Integer.parseInt(number);
        boolean ageIsLessThanZero = age<0;
        boolean ageIsGreaterThanAHundred = age >100;
        if (ageIsLessThanZero) {
            throw new DataException("La edad no puede ser menor que cero.");
        }
        if (ageIsGreaterThanAHundred) {
            throw new DataException("La edad no puede superar los 100 años.");
        }
        return new Age(number);
    }
}
