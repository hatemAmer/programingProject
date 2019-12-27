package com.company.move.Ability;

import com.company.champion.Champion;
import com.company.damageCulcolator.BasicAttackDodgeCalculator;
import com.company.damageCulcolator.DamageCalculator;
import com.company.move.Move;

import java.util.ArrayList;

public class AatroxAbilityMove extends Move {
    ArrayList<Champion> SRCArena;
    private AatroxAbilityMove(){}
    public AatroxAbilityMove(Champion champion,ArrayList<Champion>SRCArena){
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
            if(CA.getPlayer()!=CA2.getPlayer() && dis<=25){
                SRCArena.get(i).getCurrentDamageCalculator().setAttackDamage(250);
                SRCArena.get(i).setCurrentDamageCalculator(new BasicAttackDodgeCalculator(SRCArena.get(i).getCurrentDamageCalculator(),SRCArena.get(i)));
                SRCArena.get(i).AcceptDamage();
            }
        }
    }
}
