package DataBase;

import Domain.User;

interface UserRepository {
    void saveUser (User user);
    void upDateUser (User user);
    void deleteUser (User user);
    void getUser (String dni);
    void getAllUser();





}
