package com.company.move;

import com.company.champion.Champion;

/**
 * Write a description of Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Move {
    protected Champion championSrc;
    public Move(){}
    public Move(Champion championSrc){this.championSrc = championSrc;}
    public abstract void PerformMove();
}
