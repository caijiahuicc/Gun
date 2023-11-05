package com.base;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class canvasApplication extends Application {
    private static final double WIDTH = 800;
    private static final double HIGHT = 800;
    private Canvas canvas = new Canvas(WIDTH,HIGHT);
    private GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
    //画布快照返回
    private WritableImage image = null;
    private double x = 0.0;
    private double y = 0.0;

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        canvas.setLayoutX(0);
        canvas.setLayoutY(0);

        //绘制2D图形
//        graphicsContext.setLineWidth(10);
//        graphicsContext.setStroke(Color.GREEN);
//        graphicsContext.setFill(Color.BLUE);
        //样式设置应该放在.strokeRect的前面
//        graphicsContext.strokeRect(30,30,200,200);  绘制一个正方形
 //       graphicsContext.fillOval(30,30,200,200);

        //绘图操作
        canvas.setOnMousePressed(event -> {
            x = event.getX();
            y = event.getY();
        });

        //实时绘制线段
//        canvas.setOnMouseDragged(event -> {
//            double x1 = event.getX();
//            double y1 = event.getY();
//            graphicsContext.strokeLine(x,y,x1,y1);
//            x = x1;
//            y = y1;
//        });

        //绘制形状
        canvas.setOnMouseDragged(event -> {
            double startx = x;
            double starty = y;
            double endx = event.getX();
            double endy = event.getY();

            if(endx < startx){
                startx = endx;
                endx = x;
            }
            if(endy < starty){
                starty = endy;
                endy = y;
            }

            double with = endx - startx;
            double height = endy - starty;
            //不做清理的时候，会出现移动的所有轨迹都会记录
            graphicsContext.clearRect(0,0,WIDTH,HIGHT);
           //先画快照，再绘制图像
            graphicsContext.drawImage(image,0,0,WIDTH,HIGHT);
            graphicsContext.strokeRect(startx,starty,with,height);
        });

        //松开鼠标的方法
        canvas.setOnMousePressed(event -> {
            //获取画布的快照
            image = canvas.snapshot(null,null);
        });
        AnchorPane anchorPane = new AnchorPane(canvas);
        Scene scene = new Scene(anchorPane);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
