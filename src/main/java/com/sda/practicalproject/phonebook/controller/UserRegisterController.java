package com.sda.practicalproject.phonebook.controller;

import com.sda.practicalproject.phonebook.database.user.User;
import com.sda.practicalproject.phonebook.database.user.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserRegisterController {

    @FXML
    private TextField usernameText;

    @FXML
    private TextField passwordText;

    @FXML
    private Button registerUser;

    @FXML
    private Label errorText;

    @FXML
    private void handleUserRegister() {
        if(usernameText.getText().isEmpty() || passwordText.getText().isEmpty()){
            errorText.setText("The fields cannot be empty");
        } else{
            createUser();
        }
    }

    private void createUser(){
        if (QueryDAO.usernameIsUnique(usernameText.getText())) {
            User user = new User(usernameText.getText(), passwordText.getText());
            UserDAO.createUser(user);

            goToLogin();
        } else {
            errorText.setText("Username already taken!");
        }
    }


    @FXML
    private void goToLogin() {
        Navigate.goTo(registerUser, "/fxml/login.fxml");
    }

}