package com.company.round;

import com.company.champion.Champion;
import com.company.Player.Player;
import com.company.game.Option;
import com.company.game.Square;
import com.company.store.ChampionClassFilter;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;

import java.util.ArrayList;

public class Planning extends Round {
    private  static int roundNumber =0;
    private static ArrayList<Champion> arena;
    private static Square map[][];
    private Planning(){}
    public Planning(ArrayList<Champion> arena,Square map[][]){
        this.arena = arena;
        this.map = map;
    }
    @Override
    public void startAction(ArrayList<Player> pl) throws Exception {
        roundNumber++;
//        BotsGUI.bots.setBattleField(arena);
        Thread arrThread[] = new Thread[8];
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
                int finalI = i;
                arrThread[i] = new Thread(new Runnable() {
                    private ArrayList<Champion> arena = Planning.arena;

                    @Override
                    public void run() {
                        ArrayList<Champion>temp = null;
                        try{
                           temp = (new TemporalStoreFilter(new ChampionClassFilter(new StoreFilter()))).GetChampionList();
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        pl.get(finalI).addCoin(Option.getObject().getCoinePerRound());
                        try {
                            pl.get(finalI).start(this.arena,temp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
                arrThread[i].start();
//                ArrayList<Champion>temp = (new TemporalStoreFilter(new ChampionClassFilter(new StoreFilter()))).GetChampionList();
//                pl.get(i).addCoin(Option.getObject().getCoinePerRound());
//                pl.get(i).start(this.arena,temp);

                //pl.get(i).start(arena);
            }
        }
        System.out.println("Round Number:"+roundNumber);
        Thread.sleep(30000);
        for(int i =0 ;i<8;i++){
            if(arrThread[i] != null)
                arrThread[i].interrupt();
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
