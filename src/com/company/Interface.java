package com.company;

import com.company.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.Button.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

import java.awt.*;
import java.io.FileNotFoundException;

public class Interface {

    Stage window;
    Scene scene1, scene2;
    VBox listOptions;
    Button newGameButton, optionsButton, exitButton;

    public Interface(Stage window, Scene scene1, Scene scene2) {
        this.window = window;
        this.scene1 = scene1;
        this.scene2 = scene2;
        setScene1();
    }

    public void setScene1() {
        setListOptions();

        Pane layout = new Pane();
        layout.getChildren().addAll(listOptions);

        scene1 = new Scene(layout, 250, 300);
        scene1.getStylesheets().add("styles.css");
        window.setTitle("Tactical Chaos TM");
        window.setScene(scene1);
        window.show();
    }

    public void setListOptions() {
        setNewGameButton();
        setOptionsButton();
        setExitButton();

        listOptions = new VBox(20);
        listOptions.getChildren().addAll(newGameButton, optionsButton, exitButton);
        listOptions.setLayoutX(50);
        listOptions.setLayoutY(50);
    }

    public void setNewGameButton() {
        newGameButton = new Button("New Game");
        newGameButton.setMinWidth(150);
        newGameButton.setOnAction(e -> {
            this.window.setScene(scene2);
            Controller controller = new Controller(window, scene2);
            try {
                controller.start();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

    public void setOptionsButton() {
        optionsButton = new Button("Options");
        optionsButton.setMinWidth(150);
    }

    public void setExitButton() {
        exitButton = new Button("Exit");
        exitButton.setMinWidth(150);
        exitButton.setOnAction(e -> {
            window.close();
        });
    }

}
