package Aplication;

import DataBase.MySqlRepository;
import DataBase.MySqlRepositoryException;
import Domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    MySqlRepository mySqlRepository;

    public UserManager(MySqlRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }
    public void saveUser (User user) throws MySqlRepositoryException {
        List<User> users = new ArrayList<>();
        users = mySqlRepository.getUserByDni(user.getDni().getString());
        if (users.isEmpty()){
            mySqlRepository.saveUser(user);
        }else{
            throw new MySqlRepositoryException("El usuario indicado ya está registrado en la base de datos.");
        }

    }

    public User getUserByDni(String dni) throws MySqlRepositoryException {
        List<User> users;
        users = mySqlRepository.getUserByDni(dni);
        if (users.isEmpty()){
            throw new MySqlRepositoryException("El DNI indicado no está registrado en la base de datos.");
        }
        return users.get(0);
    }

    public void upDateUser(User userSolicited) throws MySqlRepositoryException{
        User user = getUserByDni(userSolicited.getDni().getString());
        mySqlRepository.upDateUser(userSolicited);
    }
}
