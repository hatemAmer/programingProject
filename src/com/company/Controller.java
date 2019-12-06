package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;

public class Controller {
    Stage window;
    Scene scene;
    String[] images = new String[3];
    VBox tiers, bottom;
    Pane bench, temporalStore;
    Pane battleField;
    ArrayList<ImageV> imagesInArena = new ArrayList<ImageV>();
    ArrayList<ImageV> imagesInBench = new ArrayList<ImageV>();
    ArrayList<ImageV> imagesInTemporalStore = new ArrayList<ImageV>();

    public Controller(Stage primaryStage,Scene scene) {
        this.window = primaryStage;
        this.scene = scene;
    }

    public void setTiers() {
        tiers = new VBox();
        ((VBox) tiers).setAlignment(Pos.BASELINE_LEFT);
        tiers.getStyleClass().add("left");
        tiers.setMinWidth(100);
    }

    public void setBench() throws FileNotFoundException {
        bench = new Pane();
        //bench.setAlignment(Pos.TOP_LEFT);
        bench.getStyleClass().add("bottom");
        bench.setMinHeight(80);
        bench.setMaxHeight(80);
        int player = 1, level = 1;
        imagesInBench.add(new ImageV(images[0], "Att P" + player + " L" + level));
        imagesInBench.get(0).setPosition(200, 5);
        imagesInBench.add(new ImageV(images[1], "Att P" + player + " L" + level));
        imagesInBench.get(1).setPosition(280, 5);

        for (ImageV imageV : imagesInBench) {
            imageV.addItemToContextMenu("Swap to");
            imageV.setContextMenu();
            //imageV.setDropListAction(0);
        }

        for (ImageV imageV : imagesInBench)
            bench.getChildren().add(imageV.getvBox());
    }
    
     public void setTiers() {
        tiers = new VBox();
        ((VBox) tiers).setAlignment(Pos.BASELINE_LEFT);
        tiers.getStyleClass().add("left");
        tiers.setMinWidth(100);
    }

    public void setBench() throws FileNotFoundException {
        bench = new Pane();
        //bench.setAlignment(Pos.TOP_LEFT);
        bench.getStyleClass().add("bottom");
        bench.setMinHeight(80);
        bench.setMaxHeight(80);
        int player = 1, level = 1;
        imagesInBench.add(new ImageV(images[0], "Att P" + player + " L" + level));
        imagesInBench.get(0).setPosition(200, 5);
        imagesInBench.add(new ImageV(images[1], "Att P" + player + " L" + level));
        imagesInBench.get(1).setPosition(280, 5);

        for (ImageV imageV : imagesInBench) {
            imageV.addItemToContextMenu("Swap to");
            imageV.setContextMenu();
            //imageV.setDropListAction(0);
        }

        for (ImageV imageV : imagesInBench)
            bench.getChildren().add(imageV.getvBox());
    }

    public void setTemporalStore() throws FileNotFoundException {
        temporalStore = new Pane();
        //((HBox) temporalStore).setAlignment(Pos.BOTTOM_CENTER);
        temporalStore.getStyleClass().add("bottom");
        temporalStore.setMinHeight(80);
        temporalStore.setMaxHeight(80);
        int player = 1, level = 1,copies = 5;
        imagesInTemporalStore.add(new ImageV(images[0], "Att L" + level + " C" + copies));
        imagesInTemporalStore.get(0).setPosition(200, 5);
        imagesInTemporalStore.add(new ImageV(images[1], "Att L" + level + " C" + copies));
        imagesInTemporalStore.get(1).setPosition(280, 5);

        for (ImageV imageV : imagesInTemporalStore) {
            imageV.addItemToContextMenu("Buy");
            imageV.setContextMenu();
            //imageV.setDropListAction(0);
        }

        for (ImageV imageV : imagesInTemporalStore)
            temporalStore.getChildren().add(imageV.getvBox());
    }

    public void setBottom() throws FileNotFoundException {
        bottom = new VBox();
        //bottom.setMinHeight(100);
        setBench();
        setTemporalStore();
        bottom.getChildren().addAll(bench, temporalStore);
    }

    public void setBattleField() throws FileNotFoundException {
        battleField = new Pane();
        battleField.getStyleClass().add("battleField");

        int player = 1, level = 1;
        imagesInArena.add(new ImageV(images[0], "Att P" + player + " L" + level));
        imagesInArena.get(0).setPosition(550, 200);
        imagesInArena.add(new ImageV(images[1], "Att P" + player + " L" + level));
        imagesInArena.get(1).setPosition(150, 100);

        for (ImageV imageV : imagesInArena) {
            imageV.addItemToContextMenu("Attack");
            imageV.addItemToContextMenu("Move");
            imageV.addItemToContextMenu("Sell");
            imageV.addItemToContextMenu("Set ability");
            imageV.setContextMenu();
            imageV.setDropListAction(0);
        }

        for (ImageV imageV : imagesInArena)
            battleField.getChildren().add(imageV.getvBox());
    }

    public void start() throws Exception {
        window.setTitle("Game");

        for (int i = 0; i < 3; i++)
            images[i] = new String();
        images[0] = "C:\\Users\\Asus\\IdeaProjects\\Programming languges project\\src\\Aatrox.jpg";
        images[1] = "C:\\Users\\Asus\\IdeaProjects\\Programming languges project\\src\\Aatrox_Render.png";

        setTiers();
        setBattleField();
        setBottom();

        BorderPane layout = new BorderPane();
        layout.setLeft(tiers);
        layout.setBottom(bottom);
        layout.setCenter(battleField);

        scene = new Scene(layout, 1000, 600);

        scene.getStylesheets().add("styles.css");
        window.setX(200);
        window.setY(50);
        window.setScene(scene);
        window.show();
    }

}
