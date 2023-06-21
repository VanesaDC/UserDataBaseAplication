package Aplication;

import DataBase.MySqlRepository;
import DataBase.MySqlRepositoryException;
import Domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserSingUp {
    MySqlRepository mySqlRepository;

    public UserSingUp(MySqlRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }
    public void saveUser (User user) throws MySqlRepositoryException {
        List<User> users = new ArrayList<>();
        users = mySqlRepository.getUserByDni(user);
        if (users.isEmpty()){
            mySqlRepository.saveUser(user);
        }else{
            throw new MySqlRepositoryException("El usuario indicado ya está registrado en la base de datos.");
        }

    }
}
