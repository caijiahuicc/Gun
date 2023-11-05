package com.even;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class lisent extends Application {
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
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHEAT);
        //圆的位置与面板的位置形成了相对位置，业务逻辑简单，可以只使用绑定
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));

        //监听器的实现，业务逻辑比较复杂的时候，可以使用监听事件
        circle.centerXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("X轴中心点改变了，原来是"+oldValue+"，现在是"+newValue);
            }
        });

        anchorPane.getChildren().add(circle);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
