package com.company.move;

import com.company.champion.Champion;
import com.company.damageCulcolator.BasicAttackDamageCalculator;
import com.company.damageCulcolator.BasicAttackDodgeCalculator;
import com.company.damageCulcolator.DamageCalculator;
import com.company.game.Square;
import com.company.game.SquareType;

/**
 * Write a description of BasicAttackMove here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicAttackMove extends Move {
    private Champion championTarget;

    private BasicAttackMove(){}

    public BasicAttackMove(Champion championSrc, Champion championTarget){
        this.championSrc = championSrc;
        this.championTarget = championTarget;
    }

    public void PerformMove(){
        this.championSrc.GetIntendedDamage();
        DamageCalculator dm = new BasicAttackDamageCalculator(this.championSrc.getCurrentDamageCalculator(),this.championSrc);
        Champion.ChampionAttributes CASrc = this.championSrc.new ChampionAttributes();
        Champion.ChampionAttributes CATarget = this.championTarget.new ChampionAttributes();
        int dis = CASrc.getSquare().getDistace(CATarget.getSquare());
        if(CASrc.getSquare().getType() == SquareType.Grass)
            dis*=2;
        if(dis <=CASrc.getAttackRange()){
            System.out.println(CASrc.getPlayer()+":"+CASrc.getName()+"+"+CASrc.getHealth() + "->" +CATarget.getPlayer()+":"+CATarget.getHealth());
            dm = new BasicAttackDodgeCalculator(this.championSrc.getCurrentDamageCalculator(),this.championTarget);
            //dm.CalculateIntendedDamage();
            this.championTarget.setCurrentDamageCalculator(dm);
            this.championTarget.AcceptDamage();
            CASrc.setManaStart(CASrc.getManaStart()+1);
        }

    }

}
