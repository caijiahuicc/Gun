package com.base;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class note extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("JavaFX新知识，我学！");
        label.setLayoutX(100);
        label.setLayoutY(200);
        label.setStyle("-fx-background-color: red;-fx-border-color: blue;-fx-border-width: 3px");
        label.setPrefWidth(200);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
        //透明度
        label.setOpacity(0.5);
        //旋转度数
        label.setRotate(70);
        //横移 竖移
        label.setTranslateX(40);
        label.setTranslateY(40);
        label.setVisible(true);
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(label);

        Scene scene = new Scene(anchorPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
