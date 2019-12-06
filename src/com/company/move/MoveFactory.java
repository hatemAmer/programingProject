package com.company.move;

import com.company.champion.Champion;

public class MoveFactory {
    public void MakeBuyMove(Champion src, int playerNumber){
         new BuyMove(src,playerNumber);
    }public void MakeSellMove(Champion src){
        new SellMove(src);
    }
}
