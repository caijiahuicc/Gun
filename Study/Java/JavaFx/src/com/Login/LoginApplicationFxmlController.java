package com.Login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import javax.lang.model.element.VariableElement;

/**
 * @author cc
 * @create 2023/10/30
 * @description
 */
public class LoginApplicationFxmlController {

    @FXML
    private CheckBox remember;

    @FXML
    private PasswordField passWord;

    @FXML
    private AnchorPane parentView;

    @FXML
    private Button login;

    @FXML
    private TextField userName;

    public void getUserName(){
        String text = userName.getText();

    }
}
