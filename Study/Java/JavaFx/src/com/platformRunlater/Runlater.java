package com.platformRunlater;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class Runlater extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("姓名是：");
        label.setLayoutX(200);
        label.setLayoutY(200);

        Button button = new Button("获取名称");
        button.setLayoutX(200);
        button.setLayoutY(300);

        Button button1 = new Button("获取头像");
        button1.setLayoutX(200);
        button1.setLayoutY(400);

        ImageView imageView = new ImageView();

        //事件处理，另起线程
        button.setOnAction(event -> {

            Thread thread = new Thread(() -> {
                String nameView = label.getText().concat("小蔡");

                Platform.runLater(() ->{
                    //刷新UI,相当于是在Application线程里面执行的队列，当Application空闲的时候，会执行队列里面的任务
                    //大部分的事件都是在Application队列线程里面执行的；
                    label.setText(nameView);
                });
            });
            thread.start();
        });

        button1.setOnAction(event -> {
            Thread thread = new Thread(() ->{
                Image image = new Image("Https://gitee.com/picture.jpg",true);

                image.progressProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        int propress = (int) newValue.doubleValue() * 100;
                        label.setText("图片加载出来了"+propress+"%");
                    }
                });
                imageView.setImage(image);
            });
            thread.start();
        });

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(label,button,imageView,button1);
        Scene scene = new Scene(anchorPane,600,600);
        primaryStage.setTitle("Hello");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
