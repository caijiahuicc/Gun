package com.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class applicationController extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Pane root = FXMLLoader.load(getClass().getResource("applicationControllerFxml.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("applicationControllerFxml.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        ApplicationControllerFxml controller = fxmlLoader.getController();
        controller.circleLocationBind(scene);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
