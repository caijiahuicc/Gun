package com.even;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class dropEvent extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane, 500, 500);

        //拖拽文件事件，显示文件的路径
        TextField textField = new TextField();
        textField.setLayoutX(200);
        textField.setLayoutY(200);
        anchorPane.getChildren().add(textField);
        textField.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.ANY);
        });

        textField.setOnDragDropped(event -> {
            Dragboard dragboard = event.getDragboard();
            if(dragboard.hasFiles()){
                String path = dragboard.getFiles().get(0).getAbsolutePath();
                textField.setText(path);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.show();
    }
}
