package com.base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class testtwo extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("窗口1");
        button.setLayoutX(200);
        button.setLayoutY(200);

        Button button1 = new Button("窗口2");
        button1.setLayoutX(200);
        button1.setLayoutY(200);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button,button1);
        button1.setOnAction(e ->{
            Stage stage = new Stage();
            stage.setHeight(400);
            stage.setWidth(400);
            stage.initOwner(primaryStage);
         //   stage.initModality(Modality.NONE);
         //   stage.initModality(Modality.APPLICATION_MODAL);
         //   stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        });



        Scene scene = new Scene(anchorPane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.getIcons().add(new Image("source/image/img.png"));
        primaryStage.setResizable(false);
     //   primaryStage.initStyle(StageStyle.DECORATED);
     //   primaryStage.initStyle(StageStyle.UNDECORATED);  自定义窗口样式的时候可以使用
     //   primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }
}
