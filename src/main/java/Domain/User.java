package Domain;

import java.util.Objects;

public class User {
    private final String dni;
    private String name;
    private String surname1;
    private String surname2;
    private int age;

    public User(String dni, String name, String surname1, String surname2, int age) {
        this.dni = dni;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return age == user.age && Objects.equals(dni, user.dni) && Objects.equals(name, user.name) && Objects.equals(surname1, user.surname1) && Objects.equals(surname2, user.surname2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, name, surname1, surname2, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
