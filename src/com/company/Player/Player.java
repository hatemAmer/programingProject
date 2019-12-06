package com.company.Player;
/**
 * Write a description of com.company.Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.company.champion.Champion;

import java.util.ArrayList;

public abstract class Player {

    protected ArrayList<Champion> currentChampionInArena = new ArrayList<Champion>();
    protected ArrayList<Champion> currentChampionInBench = new ArrayList<Champion>();
    protected int championInArena = 0;
    protected int armySizeInArena = 9;
    protected int armySizeInBench = 8;
    protected int championInBench = 0;
    protected int armySize = 17;
    protected int coin = 0;
    protected int myNumber;

    public Player(){}

    public boolean isValidBuyMove(){
        return (armySize > championInArena + championInBench) && (championInBench < armySizeInBench);
    }

    public void addCoin(int coin){this.coin += coin;}

    public int getCoin(){return this.coin;}

    public void setMyNumber(int myNumber){this.myNumber = myNumber;}

    public int getMyNumber(){return this.myNumber;}

    public abstract void buildTempStore(ArrayList<Champion> ch);

    public abstract void setPlan(ArrayList<Champion> arena);

}
