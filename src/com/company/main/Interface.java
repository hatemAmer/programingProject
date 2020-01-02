package com.company.main;

import com.company.game.Game;
import com.company.game.Option;
import com.company.setting.OptionGUI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

public class Interface {

    Stage window;
    Scene scene1, scene2, scene3, scene4;
    VBox listOptions;
    Button newGameButton, loadButton, optionsButton, exitButton;

    public Interface(Stage window, Scene scene1, Scene scene2, Scene scene3, Scene scene4) {
        this.window = window;
        this.scene1 = scene1;
        this.scene2 = scene2;
        this.scene3 = scene3;
        this.scene4 = scene4;
        setScene1();
    }

    public void setScene1() {
        setListOptions();

        Pane layout = new Pane();
        layout.getChildren().addAll(listOptions);
        layout.getStyleClass().add("layout1");
        scene1 = new Scene(layout, 700, 400);
        scene1.getStylesheets().add("cssFiles/styles.css");
        window.setTitle("Game");
        window.setScene(scene1);
        // Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX(300);
        window.setY(150);
        window.show();

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }

    private void closeProgram() {
        ConfirmBox.display("Save", "You want to save");
        boolean answer = ConfirmBox.answer;
        if (answer) {
            window.close();
        }

    }

    public void setListOptions() {
        setNewGameButton();
        setLoadButton();
        setOptionButton();
        setExitButton();

        listOptions = new VBox(20);
        listOptions.setAlignment(Pos.CENTER);
        listOptions.getChildren().addAll(newGameButton, loadButton, optionsButton, exitButton);
        listOptions.setLayoutX(310);
        listOptions.setLayoutY(100);

    }

    public void setNewGameButton() {
        newGameButton = new Button("New Game");

        newGameButton.setMinWidth(70);

        newGameButton.setOnAction(e -> {

            File file1 = new File("player1.txt");
            File file2 = new File("store.txt");
            //File file3 = new File("autoPlayer1.txt");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file1);
                writer.print("");
                writer.close();

                writer = new PrintWriter(file2);
                writer.print("");
                writer.close();

                String autoPlayerfile = "autoPlayer";
                int j = 1;
                for (int i = 0; i < Option.getObject().getNumberOfBots(); i++) {
                    File file = new File(autoPlayerfile + j + ".txt");
                    j++;
                    writer = new PrintWriter(file);
                    writer.print("");
                    writer.close();
                }
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            Game game = null;
            try {
                game = new Game(Option.getObject().getNumberOfBots(), Option.getObject().getNumberOfPlayers(), window, scene2);
                game.new TacticalChaosTM(Option.getObject().getNumberOfRound()).RunTurnGUI();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        newGameButton.getStyleClass().add("buttonStart");
    }

    public void setLoadButton() {
        loadButton = new Button("Load Game");
        loadButton.setOnAction(e -> {
            Game game = null;
            try {
                game = new Game(Option.getObject().getNumberOfBots(), Option.getObject().getNumberOfPlayers(), window, scene2);
                game.new TacticalChaosTM(Option.getObject().getNumberOfRound()).RunTurnGUI();

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        loadButton.setMinWidth(70);
        loadButton.getStyleClass().add("buttonStart");
    }

    public void setOptionButton() {
        optionsButton = new Button("Options");
        optionsButton.setOnAction(e -> {
            this.window.setScene(scene3);
            OptionGUI optionGUI = new OptionGUI(window, scene3, scene1);
        });
        optionsButton.setMinWidth(70);
        optionsButton.getStyleClass().add("buttonStart");
    }

    public void setExitButton() {
        exitButton = new Button("Exit");
        exitButton.setMinWidth(70);
        exitButton.getStyleClass().add("buttonStart");
        exitButton.setOnAction(e -> {
            window.close();
        });
    }

}

//      watch
//      this.window.setScene(scene4);
//    BotsGUI.bots = new BotsGUI(window, scene4);
//    Game game = new Game();
//    Game.RoundManager RM = game.new TacticalChaosTM();
//            try {
//        RM.RunTurn();
//    } catch (Exception e1) {
//        e1.printStackTrace();
//    }

