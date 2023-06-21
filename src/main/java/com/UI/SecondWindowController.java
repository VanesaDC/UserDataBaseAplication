package com.UI;

import Aplication.UserManager;
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
    MySqlRepository mySqlRepository = new MySqlRepository();
    UserManager userManager = new UserManager(mySqlRepository);
    User user;


    private void cleanText() {
        edtDni.setText("");
        edtName.setText("");
        edtAge.setText("");
        edtEmail.setText("");
    }

    public void saveUser()  {
        try {
            Dni dni= Dni.createDni(edtDni.getText());
            Name name =Name.createName(edtName.getText());
            Age age= Age.createAge(edtAge.getText());
            Email email= Email.createEmail(edtEmail.getText());
            user = new User(dni, name, age,email);
            userManager.saveUser(user);
            cleanText();
        } catch (EmailException | DniException | AgeException | NameException | MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
    }

    public void selectUser(){
        try {
            user = userManager.getUserByDni(edtDni.getText());
            edtName.setText(user.getName().getString());
            edtAge.setText(user.getAge().getString());
            edtEmail.setText(user.getEmail().getString());
        } catch (MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }

    }
    public void udDateUser(){
        try {
            user.setName(Name.createName(edtName.getText()));
            user.setAge(Age.createAge(edtAge.getText()));
            user.setEmail(Email.createEmail(edtEmail.getText()));
            userManager.upDateUser(user);
        } catch ( MySqlRepositoryException | EmailException| AgeException | NameException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
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
