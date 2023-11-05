package com.base;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class closewindow extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //取消操作系统默认退出事件
        Platform.setImplicitExit(false);
        primaryStage.setOnCloseRequest(event -> {
            //取消关闭窗口的动作
            event.consume();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("退出程序");
            alert.setHeaderText(null);
            alert.setContentText("是否要退出程序？");

            //选择是否退出程序
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                //结束程序
                Platform.exit();
                //只关闭窗口
                //primaryStage.close();
            }
        });

        primaryStage.setTitle("Hello");
        primaryStage.getIcons().add(new Image("source/image/img.png"));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }
}
