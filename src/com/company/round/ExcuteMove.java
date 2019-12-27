package com.company.round;

import com.company.champion.Champion;
import com.company.Player.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExcuteMove extends Round {
    private ArrayList<Champion> arena;
    private ExcuteMove(){}
    public ExcuteMove(ArrayList<Champion>arena){this.arena=arena;}
    @Override
    public void startAction(ArrayList<Player> pl) throws FileNotFoundException {
        for(int i =0 ;i<pl.size();i++){
            ArrayList<Champion> ch = pl.get(i).getCurrentChampionInArena();
            for(int j=0;j<ch.size();j++){
                if(((ch.get(j).new ChampionAttributes()).getHealth() <= 0)){
                    this.arena.remove(ch.get(j));
                    ch.remove(j);
                    j--;
                    pl.get(i).setChampionInArena(-1);
                    pl.get(i).setArmySize(-1);
                    continue;
                }
                if(ch.get(j).new ChampionAttributes().getStuns() > 0){
                    ch.get(j).new ChampionAttributes().setStuns(ch.get(j).new ChampionAttributes().getStuns()-1);
                    continue;
                }
                if(((ch.get(j).new ChampionAttributes()).getMoves()) != null)
                {
                    ((ch.get(j).new ChampionAttributes()).getMoves()).PerformMove();
                    ch.get(j).new ChampionAttributes().setMoves(null);
                }
            }
        }
    }
}
