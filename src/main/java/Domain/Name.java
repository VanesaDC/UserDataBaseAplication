package Domain;

public class Name {
    private String name;
    private Name(String name){
        this.name = name;
    }
    public String getString(){
        return name;
    }

    public static Name createName(String name) throws DataException{
        boolean nameNotContainsOnlyLetters = !name.matches("[a-zA-Z]*");
        boolean nameIsEmpty = name.isEmpty();
        if (nameIsEmpty){
            throw new DataException("El nombre no puede estar vacío.");
        }
        if (nameNotContainsOnlyLetters){
            throw new DataException("El nombre solo puede contener letras.");
        }
        return new Name(name);
    }
}
