package com.company.round;

import com.company.champion.Champion;
import com.company.Player.Player;
import com.company.game.Option;
import com.company.store.ChampionClassFilter;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;

import java.util.ArrayList;

public class Planning extends Round {
    private ArrayList<Champion> arena;
    private Planning(){}
    public Planning(ArrayList<Champion> arena){
        this.arena = arena;
    }
    @Override
    public void startAction(ArrayList<Player> pl) throws Exception {
//        BotsGUI.bots.setBattleField(arena);
        for(int i=0;i<pl.size();i++){
            ArrayList<Champion> ch = pl.get(i).getCurrentChampionInArena();
            for(int j=0;j<ch.size();j++){
                if(((ch.get(j).new ChampionAttributes()).getHealth() <= 0)){
                    this.arena.remove(ch.get(j));
                    ch.remove(j);
                    pl.get(i).setChampionInArena(-1);
                    pl.get(i).setArmySize(-1);
                }
            }
            if(pl.get(i).isRunning())
            {
                ArrayList<Champion>temp = (new TemporalStoreFilter(new ChampionClassFilter(new StoreFilter()))).GetChampionList();
                pl.get(i).addCoin(Option.getObject().getCoinePerRound());
                pl.get(i).start(this.arena,temp);

                //pl.get(i).start(arena);
            }
        }
    }
    public void startActionGUI(ArrayList<Player> pl) throws Exception {
        for (int i = 0; i < pl.size(); i++) {
            ArrayList<Champion> ch = pl.get(i).getCurrentChampionInArena();
            for (int j = 0; j < ch.size(); j++) {
                if (((ch.get(j).new ChampionAttributes()).getHealth() <= 0)) {
                    this.arena.remove(ch.get(j));
                    ch.remove(j);
                    pl.get(i).setChampionInArena(-1);
                    pl.get(i).setArmySize(-1);
                }
            }
        }
    }
}
