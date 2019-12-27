package com.company.move.Ability;

import com.company.champion.Champion;
import com.company.move.Move;

import java.util.ArrayList;

public class AhriAbilityMove extends Move {
    ArrayList<Champion> SRCArena;
    private AhriAbilityMove(){}
    public AhriAbilityMove(Champion champion,ArrayList<Champion>SRCArena){
        this.SRCArena=SRCArena;
        this.championSrc=champion;
    }
    @Override
    public void PerformMove() {
        Champion.ChampionAttributes CA = this.championSrc.new ChampionAttributes();
        for(int i=0;i<SRCArena.size();i++) {
            Champion.ChampionAttributes CA2 = SRCArena.get(i).new ChampionAttributes();
            if(CA.getPlayer()!=CA2.getPlayer() && (CA2.getSquare().getX()<CA.getSquare().getX() && CA2.getSquare().getY()<CA.getSquare().getY())){
                CA2.setManaStart(CA2.getManaStart()-100);
                CA2.setHealth(CA2.getHealth()-100);
            }
        }
    }
}
