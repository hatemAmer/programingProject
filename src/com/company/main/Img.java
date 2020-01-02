package com.company.main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Img {
    javafx.scene.image.Image image;
    ImageView imageView;

    public Img(String filename) throws FileNotFoundException {
        image = new javafx.scene.image.Image(new FileInputStream(filename));
        imageView = new ImageView(image);

        setImageSize(100, 100);
    }

    public void setImageSize(int x, int y) {
        imageView.setFitHeight(x);
        imageView.setFitWidth(y);
    }

    public void setImagePos(int x, int y) {
        imageView.setX(x);
        imageView.setY(y);
    }

    public ImageView getImage() {
        return imageView;
    }
}
