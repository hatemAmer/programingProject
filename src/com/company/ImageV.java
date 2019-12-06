package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.VBox;

public class ImageV {
    VBox vBox = new VBox();
    Image image;
    ImageView imageView;
    ContextMenu contextMenu = new ContextMenu();
    ArrayList<MenuItem> items = new ArrayList<MenuItem>();
    int counter = 0;
    Label label;

    public ImageV(String filename,String labelText) throws FileNotFoundException {
        image = new Image(new FileInputStream(filename));
        imageView = new ImageView(image);
        setImageSize(50,50);
        this.label = new Label(labelText);
        vBox.setMaxSize(55,55);
        vBox.getChildren().addAll(imageView,this.label);
    }

    public void setLabelText(String labelText){
        this.label.setText(labelText);
    }

    public void setPosition(int x,int y){
        vBox.setLayoutX(x);
        vBox.setLayoutY(y);
    }

    public void setImageSize(int x,int y){
        imageView.setFitHeight(x);
        imageView.setFitWidth(y);
    }

    public void setImagePosition(int x,int y){
        imageView.setX(x);
        imageView.setY(y);
    }

    public void addItemToContextMenu(String item) {
        items.add(new MenuItem(item));
        contextMenu.getItems().add(items.get(counter));
        counter++;
    }

    public void setContextMenu(){
        imageView.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent contextMenuEvent) {
                contextMenu.show(imageView, contextMenuEvent.getScreenX(), contextMenuEvent.getSceneY());
            }
        });
    }

    public void setDropListAction(int num){
        items.get(num).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vBox.setLayoutX(100);
                vBox.setLayoutY(100);
            }
        });
    }

    public ImageView getImageView(){
        return this.imageView;
    }

    public VBox getvBox(){
        return this.vBox;
    }

}
