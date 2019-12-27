package com.company.move;

import com.company.champion.Champion;

import java.io.Serializable;

/**
 * Write a description of Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Move implements Serializable {
    protected Champion championSrc;
    public Move(){}
    public Move(Champion championSrc){this.championSrc = championSrc;}
    public abstract void PerformMove();
    public void print(){
        System.out.println(this.getClass().getSimpleName());

    }
}
