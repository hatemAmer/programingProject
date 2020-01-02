package com.company.game;

import java.io.Serializable;

public class Square implements Serializable {
    private int x, y;
    SquareType type;
    public Square() {
        x = -1;
        y = -1;
        type = SquareType.Standard;
    }

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistace(Square s) {
        return (int) Math.sqrt((double) ((x - s.getX()) * (x - s.getX()) + (y - s.getY()) * (y - s.getY())));
    }

    public String toString() {
        return new String("(" + this.x + "," + this.y + ":" +this.type +")");
    }

    public SquareType getType() {
        return type;
    }

    public void setType(SquareType type) {
        this.type = type;
    }
}
