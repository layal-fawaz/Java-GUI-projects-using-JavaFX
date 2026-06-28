/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author awadallah
 */
public class colorOptions extends Application {

    private List<ColorListener> windows = new ArrayList<>();

    public void addWindow(ColorListener window) {
        if (!windows.contains(window)) {
            windows.add(window);
        }
    }

    public void removeWindow(ColorListener window) {
        if (windows.contains(window)) {
            windows.remove(window);
        }
    }

    public void sendColor(String color) {
        for (ColorListener w : windows) {
            w.setSelectedColor(color);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RadioButton red = new RadioButton("red");
        RadioButton yellow = new RadioButton("yellow");
        RadioButton blue = new RadioButton("blue");
        ToggleGroup colors = new ToggleGroup();
        red.setToggleGroup(colors);
        yellow.setToggleGroup(colors);
        blue.setToggleGroup(colors);

        red.setOnAction(e -> sendColor("red"));
        blue.setOnAction(e -> sendColor("blue"));
        yellow.setOnAction(e -> sendColor("yellow"));

        HBox h = new HBox(30, red, yellow, blue);
        h.setAlignment(Pos.CENTER);
        h.setStyle("-fx-background-color: grey;");
        Scene s = new Scene(h);
        primaryStage.setScene(s);
        primaryStage.setTitle("change 2 other frames");
        primaryStage.setHeight(300);
        primaryStage.setWidth(300);
        primaryStage.setX(460); 
        primaryStage.setY(200);
        primaryStage.show();

        TextDisplayWindow textWindow = new TextDisplayWindow();
        Stage textStage = new Stage();
        textWindow.start(textStage);
        textStage.setX(120);
        textStage.setY(300);
        addWindow(textWindow);

        BackGroundColorWindow backgroundWindow = new BackGroundColorWindow();
        Stage backgroundStage = new Stage();
        backgroundWindow.start(backgroundStage);
        backgroundStage.setX(900);
        backgroundStage.setY(300);
        addWindow(backgroundWindow);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
