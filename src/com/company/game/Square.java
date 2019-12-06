package com.company.game;

public class Square {
    private int x, y;

    public Square() {
        x = -1;
        y = -1;
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

}
