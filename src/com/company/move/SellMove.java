package com.company.move;

import com.company.champion.Champion;
import com.company.game.Square;

/**
 * Write a description of SellMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SellMove extends Move{
    private SellMove(){}
    public SellMove(Champion src){
        super(src);
        this.PerformMove();
    }
    public void PerformMove(){
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        CA.setPlayer(0);
        CA.setSquare(new Square());
    }

}
