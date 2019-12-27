package com.company.move.Ability;

import com.company.champion.Champion;
import com.company.damageCulcolator.BasicAttackDodgeCalculator;
import com.company.move.Move;

import java.util.ArrayList;

public class FioraAbilityMove extends Move {
    ArrayList<Champion> SRCArena;
    private FioraAbilityMove(){}
    public FioraAbilityMove(Champion champion,ArrayList<Champion>SRCArena){
        this.SRCArena=SRCArena;
        this.championSrc=champion;
    }
    @Override
    public void PerformMove() {
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        for(int i=0;i<SRCArena.size();i++){
            Champion.ChampionAttributes CA2 = SRCArena.get(i).new ChampionAttributes();
            SRCArena.get(i).GetIntendedDamage();
            int dis = CA.getSquare().getDistace(CA2.getSquare());
            if(CA.getPlayer()!=CA2.getPlayer() && dis<=CA.getAttackRange()){
                CA2.setStuns(CA2.getStuns()+1);
            }
        }
    }
}
