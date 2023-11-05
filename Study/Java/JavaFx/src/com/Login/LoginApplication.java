package com.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/30
 * @description
 */
public class LoginApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane load = FXMLLoader.load(getClass().getResource("loginApplicationFxml.fxml"));

        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
