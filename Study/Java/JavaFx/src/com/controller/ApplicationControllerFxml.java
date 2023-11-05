package com.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class ApplicationControllerFxml {

    @FXML
    private AnchorPane tableview;

    @FXML
    private Circle circle;

    public void circleLocationBind(Scene scene){
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
    }
}
