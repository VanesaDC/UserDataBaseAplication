package Domain;



public class Name {
    private String name;
    private Name(String name){
        this.name = name;
    }
    public String getString(){
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
}
