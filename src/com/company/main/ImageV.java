package com.company.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.company.champion.Champion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ImageV {
    VBox vBox = new VBox();
    Image image;
    ImageView imageView;
    ContextMenu contextMenu = new ContextMenu();
    int counter = 0;
    Label label;
    int x, y;

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    ArrayList<MenuItem> items = new ArrayList<MenuItem>();

    public ImageV(String filename, String labelText) throws FileNotFoundException {
        image = new Image(new FileInputStream(filename));
        imageView = new ImageView(image);
        setImageSize(50, 50);
        this.label = new Label(labelText);
        this.label.getStyleClass().add("championLabel");
        this.label.setTextFill(Color.web("#ffffff",0.8));
        vBox.setMaxSize(55, 55);
       // vBox.setStyle("-fx-text-inner-color:red;");
        vBox.getChildren().addAll(imageView, this.label);
    }

    public void setLabelText(String labelText) {
        this.label.setText(labelText);
    }

    public void setPosition(int x, int y) {
        vBox.setLayoutX(x);
        vBox.setLayoutY(y);
        this.x = x;
        this.y = y;
    }

    public int getPosX() {
        return this.x;
    }

    public int getPosY() {
        return this.y;
    }

    public void setImageSize(int x, int y) {
        imageView.setFitHeight(x);
        imageView.setFitWidth(y);
    }

    public void setImagePosition(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }

    public void addItemToContextMenu(String item) {
        items.add(new MenuItem(item));
        contextMenu.getItems().add(items.get(counter));
        counter++;
    }

    public void setContextMenu() {
        imageView.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent contextMenuEvent) {
                contextMenu.show(imageView, contextMenuEvent.getScreenX(), contextMenuEvent.getSceneY());
            }
        });
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public VBox getvBox() {
        return this.vBox;
    }


}
