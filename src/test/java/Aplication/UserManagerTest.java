package Aplication;

import DataBase.MySqlRepository;
import DataBase.MySqlRepositoryException;
import Domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserManagerTest {
    MySqlRepository mockMySqlRepository = mock(MySqlRepository.class);
    UserManager userManager = new UserManager(mockMySqlRepository);
    Dni dni;
    Name name;
    Age age;
    Email email;

    @Test
    void should_throws_exception_when_user_is_already_registered() throws DniException, NameException, AgeException, EmailException, MySqlRepositoryException {
        dni = Dni.createDni("78698408K");
        name = Name.createName("Juliana");
        age = Age.createAge("34");
        email = Email.createEmail("email@gmail.com");
        User user = new User(dni, name, age, email);
        when(mockMySqlRepository.getUserByDni(dni.getString())).thenReturn(List.of(user));
        String message = assertThrows(MySqlRepositoryException.class, ()-> userManager.saveUser(user)).getMessage();
        assertEquals("El usuario indicado ya está registrado en la base de datos.", message);
    }

    @Test
    void should_save_user_when_it_not_is_registered() throws DniException, NameException, AgeException, EmailException, MySqlRepositoryException {
        dni = Dni.createDni("78698408K");
        name = Name.createName("Juliana");
        age = Age.createAge("34");
        email = Email.createEmail("email@gmail.com");
        User user = new User(dni, name, age, email);
        when(mockMySqlRepository.getUserByDni(dni.getString())).thenReturn(List.of());
        userManager.saveUser(user);
        verify(mockMySqlRepository).saveUser(user);
    }
    @Test
    void getUserByDni_should_throw_a_exception_when_the_dni_is_not_registered() throws MySqlRepositoryException {
        String dni = "51528773X";
        when(mockMySqlRepository.getUserByDni(dni)).thenReturn(List.of());
        String message = assertThrows(MySqlRepositoryException.class, ()-> userManager.getUserByDni(dni)).getMessage();
        assertEquals("El DNI indicado no está registrado en la base de datos.", message);
    }

}