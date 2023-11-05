package com.even;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class eventLisent extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 500, 500);

        Label label = new Label("Hello JavaFx");
        label.setLayoutX(200);
        label.setLayoutY(200);
        Button button = new Button("向上移动");
        button.setLayoutX(300);
        button.setLayoutY(200);
        anchorPane.getChildren().addAll(label,button);

        //设置按钮事件
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                label.setLayoutY(label.getLayoutY() - 10);
            }
        });

        //设置键盘事件，设置给场景
        //scene.setOnKeyPressed();   键盘按下触发的事件
        //scene.setOnKeyReleased();  键盘释放的时候触发的事件
        //scene.setOnKeyTyped();键盘按下后又抬起时触发的事件
        scene.setOnKeyReleased(event -> {
            KeyCode keyCode = event.getCode();
            if(keyCode.equals(KeyCode.DOWN)){
                label.setLayoutY(label.getLayoutY() + 10);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
