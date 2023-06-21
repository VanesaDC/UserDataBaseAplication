package Aplication;

import DataBase.MySqlRepository;
import DataBase.MySqlRepositoryException;
import Domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserSingUpTest {
    MySqlRepository mockMySqlRepository = mock(MySqlRepository.class);
    UserSingUp singUp = new UserSingUp(mockMySqlRepository);
    Dni dni;
    Name name;
    Age age;
    Email email;

    @Test
    void throws_exception_when_user_is_already_registered() throws DniException, NameException, AgeException, EmailException, MySqlRepositoryException {
        dni = Dni.createDni("78698408K");
        name = Name.createName("Juliana");
        age = Age.createAge("34");
        email = Email.createEmail("email@gmail.com");
        User user = new User(dni, name, age, email);
        when(mockMySqlRepository.getUserByDni(user)).thenReturn(List.of(user));
        String message = assertThrows(MySqlRepositoryException.class, ()->singUp.saveUser(user)).getMessage();
        assertEquals("El usuario indicado ya está registrado en la base de datos.", message);

    }

}