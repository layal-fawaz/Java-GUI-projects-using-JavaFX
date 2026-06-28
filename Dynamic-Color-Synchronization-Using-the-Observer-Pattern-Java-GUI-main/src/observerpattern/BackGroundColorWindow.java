/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author awadallah
 */
public class BackGroundColorWindow extends Application implements ColorListener {

    VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        vbox = new VBox();
        vbox.setStyle("-fx-background-color: blue;");
        Scene s = new Scene(vbox,250,200);
        primaryStage.setScene(s);
        primaryStage.show();
        primaryStage.setTitle("colors");
    }

    @Override
    public void setSelectedColor(String color) {
        vbox.setStyle("-fx-background-color: " + color + ";");
    }

}
