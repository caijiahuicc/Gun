package com.base;

import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class scene extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("按钮1");
        button1.setLayoutX(200);
        button1.setLayoutY(200);

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.getChildren().add(button1);

        Scene scene1 = new Scene(anchorPane1, 400, 400);

        Label label = new Label("JavaFX,新知识，我学！");
        label.setLayoutX(200);
        label.setLayoutY(200);
        Button button2 = new Button("回退");
        button2.setLayoutX(200);
        button2.setLayoutY(200);

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.getChildren().addAll(label,button2);

        Scene scene2 = new Scene(anchorPane2, 400, 400);
        scene2.setCursor(new ImageCursor(new Image("source/image/img.png")));

        button1.setOnAction(event -> {
            primaryStage.setScene(scene2);
        });

        button2.setOnAction(event -> {
            primaryStage.setScene(scene1);
        });

        primaryStage.setScene(scene1);
        primaryStage.setTitle("Hello");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
