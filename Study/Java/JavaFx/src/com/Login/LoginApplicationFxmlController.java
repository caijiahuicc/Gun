package com.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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


    @FXML
    public void loginSucess(ActionEvent event) {
        if (userName.getText().equals("caijiahui") && passWord.getText().equals("Cjh3154205825")){
            System.out.println("登录成功！");
        }
    }

    @FXML
    public void remberPwd(ActionEvent event){

    }
}
