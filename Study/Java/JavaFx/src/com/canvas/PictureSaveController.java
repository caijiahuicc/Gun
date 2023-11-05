package com.canvas;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class PictureSaveController {
    @FXML
    private MenuBar fmenvbar;

    @FXML
    private Menu help;

    @FXML
    private Canvas canvas;

    @FXML
    private Menu file;

    @FXML
    private Menu edit;

    @FXML
    private MenuItem save;

    private double x = 0.0;
    private double y = 0.0;

    @FXML
    void saveImage(ActionEvent event) {
        WritableImage writableImage = canvas.snapshot(null,null);
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage,null);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("保存canvas图片");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG","png"));
        File file = fileChooser.showSaveDialog(canvas.getScene().getWindow());
        if(file != null){
            try {
                ImageIO.write(bufferedImage,"PNG",file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    void canvasOnMouseDragged(MouseEvent event) {
        double x1 = event.getX();
        double y1 = event.getY();

        canvas.getGraphicsContext2D().strokeLine(x,y,x1,y1);
    }

    @FXML
    void canvasOnMousePressed(MouseEvent event) {
        x = event.getX();
        y = event.getY();
    }
}
