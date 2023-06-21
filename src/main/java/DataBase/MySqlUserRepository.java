package DataBase;

import Domain.User;

import java.util.List;

interface MySqlUserRepository {
    void saveUser (User user);
    void upDateUser (User user);
    void deleteUser (User user);
    List<User> getUserByDni(String dniSelected);
    List<User> getAllUser();





}
