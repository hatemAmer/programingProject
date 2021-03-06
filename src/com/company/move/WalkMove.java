package com.company.move;

import com.company.champion.Champion;
import com.company.game.Option;
import com.company.game.Square;

/**
 * Write a description of WalkMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WalkMove extends Move{
    private Square distination;
    private WalkMove(){}
    public WalkMove(Champion src,Square s){
        super(src);
        this.distination = s;
    }
    public void PerformMove(){
        Champion.ChampionAttributes CA = championSrc.new ChampionAttributes();
        int moSp = CA.getMovementSpeed();
        int distance = distination.getDistace(CA.getSquare());
        if(distance <= moSp && distination.getX()<= Option.getObject().getWidth() && distination.getX()>0 && distination.getY() <= Option.getObject().getHigth() && distination.getY()>0)
        {
            CA.setSquare(distination);
        }
    }

}
