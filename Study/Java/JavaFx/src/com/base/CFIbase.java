package com.base;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class CFIbase extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();

        Scene scene = new Scene(anchorPane, 500, 500);

        Circle circle = new Circle();
        circle.setCenterX(250);
        circle.setCenterY(250);
        circle.setRadius(100);
        //填充色   可以使用软件snipaste吸取任意颜色  Color.web("#吸取颜色值")
        circle.setFill(Color.rgb(100,100,100));
        //边框宽度
        circle.setStrokeWidth(5);
        //边框颜色
        circle.setStroke(Color.BLUE);

        Label label = new Label("JaveFX新知识，我学！");
        label.setLayoutX(100);
        label.setLayoutY(400);
        label.setFont(new Font(30));
 //       label.setFont(Font.font("创业尚未成功，小蔡仍需奋斗", FontWeight.BOLD,30));

        ImageView imageView = new ImageView();
        Image image = new Image("source/image/img.png");
        imageView.setImage(image);
        imageView.setLayoutY(50);
        imageView.setLayoutX(200);
        scene.setOnKeyReleased(event -> {
            KeyCode code = event.getCode();
            if(code.equals(KeyCode.END)){
                Platform.exit();
            }
        });
        anchorPane.getChildren().addAll(circle,label,imageView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
