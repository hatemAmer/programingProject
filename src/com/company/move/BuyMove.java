package com.company.move;

import com.company.champion.Champion;
import com.company.game.Square;

/**
 * Write a description of BuyMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuyMove extends Move{
    int playerNumber;
    private BuyMove(){}
    public BuyMove(Champion src,int player){
        super(src);
        this.playerNumber = player;
        this.PerformMove();
    }
    public void PerformMove(){
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        CA.setPlayer(playerNumber);
    }

}
