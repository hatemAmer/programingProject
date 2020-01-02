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
    public void startAction(ArrayList<Player> pl) throws FileNotFoundException, InterruptedException {
        Thread arrThread[] = new Thread[8];
        for(int i =0 ;i<pl.size();i++) {
            ArrayList<Champion> ch = pl.get(i).getCurrentChampionInArena();
            int finalI = i;

            arrThread[i] = new Thread(new Runnable() {
                private ArrayList<Champion> arena ;

                @Override
                public void run() {
                    for (int j = 0; j < ch.size(); j++) {

                        if (ch.get(j).new ChampionAttributes().getStuns() > 0) {
                            ch.get(j).new ChampionAttributes().setStuns(ch.get(j).new ChampionAttributes().getStuns() - 1);
                            continue;
                        }
                        if (((ch.get(j).new ChampionAttributes()).getMoves()) != null) {
                            int finalJ = j;
                            Champion.ChampionAttributes CA = ch.get(finalJ).new ChampionAttributes();
                            while (CA.getMoves().size() != 0) {
                                CA.getMoves().get(0).PerformMove();
                                CA.getMoves().remove(0);
                            }
                        }
                    }
                }
            });
            arrThread[i].start();
            for (int j = 0; j < ch.size(); j++){
                if (((ch.get(j).new ChampionAttributes()).getHealth() <= 0)) {
                    this.arena.remove(ch.get(j));
                    ch.remove(j);
                    j--;
                    pl.get(i).setChampionInArena(-1);
                    pl.get(i).setArmySize(-1);
                    continue;
                }
            }
        }
        Thread.sleep(500);
    }
}
