package com.layout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class Layoutfxmldemo extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        AnchorPane anchorPane = new AnchorPane();

//        Scene scene = new Scene(anchorPane, 600, 600);

//        Label label = new Label("JavaFX新知识，我学！");
//        label.setLayoutX(250);
//        label.setLayoutY(250);
//        label.setFont(new Font(30));
//
//        Button button = new Button("向上移动");
//        button.setLayoutX(150);
//        button.setLayoutY(250);
//        button.setOnAction(event -> {
//            label.setLayoutY(label.getLayoutY() - 10);
//        });
//        anchorPane.getChildren().addAll(label,button);
//        scene.setOnKeyReleased(event -> {
//            KeyCode code = event.getCode();
//            if(code.equals(KeyCode.END)){
//                Platform.exit();
//            }
//        });

        Pane root = FXMLLoader.load(getClass().getResource("layoutfxmldemo.fxml"));
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hello");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
