package com.company.move.Ability;

import com.company.champion.Champion;
import com.company.move.Move;

import java.util.ArrayList;

public class AkaliAbilityMove extends Move {
    ArrayList<Champion> SRCArena;
    private AkaliAbilityMove(){}
    public AkaliAbilityMove(Champion champion,ArrayList<Champion>SRCArena){
        this.SRCArena=SRCArena;
        this.championSrc=champion;
    }
    @Override
    public void PerformMove() {
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        for(int i=0;i<SRCArena.size();i++) {
            Champion.ChampionAttributes CA2 = SRCArena.get(i).new ChampionAttributes();
            int dis = CA.getSquare().getDistace(CA2.getSquare());
            if(CA.getPlayer() != CA2.getPlayer() && dis<=CA.getVisonRange()){
                CA2.setHealth((int)(CA2.getHealth()-CA2.getMaxHealth()*0.1));
            }
        }

    }
}
