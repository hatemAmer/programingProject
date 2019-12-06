package com.company.move;

import com.company.champion.Champion;

/**
 * Write a description of BasicAttackMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicAttackMove extends Move{
    private Champion target;

    private BasicAttackMove(){}

    public BasicAttackMove(Champion champion,Champion target){
        super(champion);
        this.target = target;
    }

    public void PerformMove(){
        Champion.ChampionAttributes CA1= championSrc.new ChampionAttributes();
        Champion.ChampionAttributes CA2 = target.new ChampionAttributes();
        CA2.setHealth(CA2.getHealth() - CA1.getAttackDamage());
    }

}
