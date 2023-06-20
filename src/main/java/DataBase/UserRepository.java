package DataBase;

import Domain.User;

public interface UserRepository {
    public void saveUser (User user);
    public void upDateUser (User user);
    public void deleteUser (User user);
    public void getUser (String dni);
    public void getAllUser();





}
