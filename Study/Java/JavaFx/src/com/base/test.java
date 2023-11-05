package com.base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author cc
 * @create 2023/10/25
 * @description
 */
public class test extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * 窗口
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start（）开始");
        //组件
      //  Label label = new Label("JavaFx新知识，我学！");
        //链接按钮
        Button button = new Button("Gitee");
        //面板
     //   BorderPane borderPane = new BorderPane(label);
        BorderPane borderPane = new BorderPane(button);
        //事件
        button.setOnAction(e ->{
            getHostServices().showDocument("Http://gitee.com");
        });
        //场景
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("测试窗口");
        primaryStage.show();
    }
}
