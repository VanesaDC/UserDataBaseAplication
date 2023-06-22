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

    private void cleanText() {
        edtDni.setText("");
        edtName.setText("");
        edtAge.setText("");
        edtEmail.setText("");
    }
    private User createUser() {
        User user = null;
        try {
            Dni dni = Dni.createDni(edtDni.getText());
            Name name =Name.createName(edtName.getText());
            Age age= Age.createAge(edtAge.getText());
            Email email= Email.createEmail(edtEmail.getText());
            user = new User(dni, name, age,email);
        } catch ( DataException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
        return user;
    }
    public void saveUser()  {
        try {
            User user = createUser();
            userManager.saveUser(user);
            cleanText();
        } catch (MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
    }
    public void selectUser(){
        try {
            User user = userManager.getUserByDni(edtDni.getText());
            edtName.setText(user.getName().getString());
            edtAge.setText(user.getAge().getString());
            edtEmail.setText(user.getEmail().getString());
        } catch (MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
    }
    public void upDateUser(){
        try {
            User user = createUser();
            userManager.upDateUser(user);
            cleanText();
        } catch ( MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
    }
    public void deleteUser(){
        try {
            userManager.deleteUser(edtDni.getText());
            cleanText();
        } catch (MySqlRepositoryException e) {
            AlertPanel.showAttentionMessageSaying(e.getMessage());
        }
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
