package com.UI;

import Aplication.UserSingUp;
import DataBase.MySqlRepository;
import DataBase.MySqlRepositoryException;
import Domain.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class SecondWindowController {
    @FXML
    private Button btnSave, btnUpDate, btnDelete, btnSelect, btnCancel;
    @FXML
    private TextField edtDni, edtName, edtAge,edtEmail;


    //Crear usuario con los datos de los campos. Validando datos
    public void saveUser()  {

        try {
            Dni dni= Dni.createDni(edtDni.getText());
            Name name =Name.createName(edtName.getText());
            Age age= Age.createAge(edtAge.getText());
            Email email= Email.createEmail(edtEmail.getText());
            User user = new User(dni, name, age,email);
            MySqlRepository mySqlRepository = new MySqlRepository();
            UserSingUp userSingUp = new UserSingUp(mySqlRepository);
            userSingUp.saveUser(user);
        } catch (EmailException | DniException | AgeException | NameException | MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }


    }
    public void selectUser(){
        //busca usuario en base de datos con dni para y muestra los datos en los campos
    }
    public void udDateUser(){
        //Crea un usuario con los nuevos datos y lo actualiza en la bd con el id seleccionado (Lo crea para validar los campos)
    }
    public void deleteUser(){
        btnDelete.setTooltip(new Tooltip("Debe buscar el usuario primero"));
        //Lama al método delete de la base de datos con el dni
    }

    public void closeSecondWindow(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
    public void showInstructionsDelete(){
        btnDelete.setTooltip(new Tooltip("Click si quiere eliminar al usuario que se muestra"));
    }
    public void showInstructionsSelect(){
        btnSelect.setTooltip(new Tooltip("Haga clic después de escribir el DNI de la persona"));
    }
    public void showInstructionsSave(){
        btnSave.setTooltip(new Tooltip("Haga clic después de completar todos los campos"));
    }
    public void showInstructionsUpDate(){
        btnUpDate.setTooltip(new Tooltip("Haga clic después de modificar todos los campos que desee cambiar"));
    }

}
