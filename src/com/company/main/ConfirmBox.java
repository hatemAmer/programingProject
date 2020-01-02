package com.company.main;

import com.company.Player.Player;
import com.company.game.Option;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ConfirmBox {

    static boolean answer;


    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            window.close();
            answer = true;
        });
        Button noButton = new Button("No");
        noButton.setOnAction(e -> {
            window.close();
            answer = true;
            File file = new File("player1.txt");
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();

            file = new File("store.txt");
            writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            writer.print("");
            writer.close();

            String autoPlayerfile = "autoPlayer";
            int j = 1;
            for (int i = 0; i < Option.getObject().getNumberOfBots(); i++) {
                file = new File(autoPlayerfile + j + ".txt");
                j++;
                writer = null;
                try {
                    writer = new PrintWriter(file);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                writer.print("");
                writer.close();
            }
        });

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(yesButton, noButton);
        hBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label, hBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout);
        window.setX(550);
        window.setY(300);
        window.setScene(scene);
        window.showAndWait();
    }

}


