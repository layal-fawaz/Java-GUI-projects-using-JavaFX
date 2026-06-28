/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author awadallah
 */
public class TextDisplayWindow extends Application implements ColorListener {

    Label selectedColor;

    @Override
    public void start(Stage primaryStage) throws Exception {
        selectedColor = new Label("selectedColor:");
        selectedColor.setPadding(new Insets(30));
        Scene s = new Scene(selectedColor, 250, 200);
        primaryStage.setScene(s);
        primaryStage.show();
        primaryStage.setTitle("color list");
    }

    @Override
    public void setSelectedColor(String color) {
        selectedColor.setText("Selected Color: " + color);
    }

}
