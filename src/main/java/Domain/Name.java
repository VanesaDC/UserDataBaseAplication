package Domain;

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
            throw new Error ("El nombre no puede estar vacío");
            //showAlertNameIsEmpty();
        }
        if (nameNotContainsOnlyLetters){
            throw new Error ("El nombre solo puede contener letras");
            //showAlertNameMustContainsOnlyLetters();
        }
        return new Name (name);
    }

    private void showAlertNameMustContainsOnlyLetters() {

    }

    private void showAlertNameIsEmpty() {
    }
}
