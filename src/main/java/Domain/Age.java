package Domain;

public class Age {
    private int age;

    private Age(int age) {
        this.age = age;
    }
    public static Age createAge(int age) throws AgeException{
        boolean ageIsLessThanZero = age<0;
        boolean ageIsGreaterThanAHundred = age >100;
        boolean ageIsADecimalNumber = age % 1 != 0;

        if (ageIsLessThanZero) {
            throw new AgeException("La edad no puede ser menor que cero");
        }
        if (ageIsGreaterThanAHundred)

        if (ageIsADecimalNumber) {
            throw new Error("Age has to be a whole number");
        }


        return new Age(age);
    }
}
