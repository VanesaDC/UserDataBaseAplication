package Domain;

public class Age {
    private int age;

    private Age(int age) {
        this.age = age;
    }
    public static Age createAge(int age) throws AgeException{
        boolean ageIsLessThanZero = age<0;
        boolean ageIsGreaterThanAHundred = age >100;

        if (ageIsLessThanZero) {
            throw new AgeException("La edad no puede ser menor que cero.");
        }
        if (ageIsGreaterThanAHundred)
            throw new AgeException("La edad no puede superar los 100 años.");

        return new Age(age);
    }
}
