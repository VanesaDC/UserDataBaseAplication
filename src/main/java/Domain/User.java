package Domain;

import java.util.Objects;

public class User {
    private Dni dni;
    private Name name;
    private Age age;
    private Email email;

    public User(Dni dni, Name name, Age age, Email email) {

        this.dni = dni;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "dni=" + dni.getDni() +
                ", name=" + name.getName() +
                ", age=" + age.getAge() +
                ", email=" + email.getEmail() +
                '}';
    }

    public Dni getDni() {
        return dni;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(dni, user.dni) && Objects.equals(name, user.name) && Objects.equals(age, user.age) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, name, age, email);
    }
}
