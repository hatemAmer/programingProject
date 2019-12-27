package com.company.move.Ability;

import com.company.champion.Champion;
import com.company.damageCulcolator.BasicAttackDodgeCalculator;
import com.company.move.Move;

import java.util.ArrayList;

public class BrandAbilityMove extends Move {
    ArrayList<Champion> SRCArena;
    private BrandAbilityMove(){}
    public BrandAbilityMove(Champion champion,ArrayList<Champion>SRCArena){
        this.SRCArena=SRCArena;
        this.championSrc=champion;
    }
    @Override
    public void PerformMove() {
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        int counter = 3;
        for(int i=0;i<SRCArena.size();i++) {
            if(counter==0)
                break;
            Champion.ChampionAttributes CA2 = SRCArena.get(i).new ChampionAttributes();
            SRCArena.get(i).GetIntendedDamage();
            int dis = CA.getSquare().getDistace(CA2.getSquare());
            if(CA.getPlayer() != CA2.getPlayer() && dis<=CA.getAttackRange()){
                SRCArena.get(i).getCurrentDamageCalculator().setAttackDamage(CA2.getMaxHealth()*0.1);
                SRCArena.get(i).setCurrentDamageCalculator(new BasicAttackDodgeCalculator(SRCArena.get(i).getCurrentDamageCalculator(),SRCArena.get(i)));
                SRCArena.get(i).AcceptDamage();
                CA2.setArmor(CA2.getArmor() - CA2.getArmor()*0.1);
                CA2.setMagicResist(CA2.getMagicResist() - CA2.getMagicResist()*0.1);
                counter--;
            }
        }
    }
}
