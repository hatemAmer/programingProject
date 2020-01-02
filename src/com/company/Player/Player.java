package com.company.Player;
/**
 * Write a description of com.company.Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.company.champion.Champion;
import com.company.champion.ChampionClass;
import com.company.game.Option;
import com.company.game.SquareType;
import com.company.move.Move;
import com.company.move.MoveFactory;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Player implements Serializable {
    protected int championClass[] = new int[20];
    protected ArrayList<ChampionClass> CHC= new ArrayList<ChampionClass>();
    protected ArrayList<Champion> currentChampionInArena = new ArrayList<Champion>();
    protected ArrayList<Champion> currentChampionInBench = new ArrayList<Champion>();
    ArrayList<Champion> currentChampionsInTemporalStore;
    protected int championInArena = 0;
    protected int armySizeInArena = Option.getObject().getLimtOfChampionInArena();
    protected int armySizeInBench = Option.getObject().getLimtOfChampionInBench();
    protected int championInBench = 0;
    protected int armySize;
    protected int coins = 0;
    protected int myNumber;
    protected boolean running = true;
    protected int limitSwaps = Option.getObject().getLimtOfSwaps(), numSwaps = 0;

    public MoveFactory move;

    public Player() {
        CHC.add(ChampionClass.Demon);
        CHC.add(ChampionClass.Dragons);
        CHC.add(ChampionClass.Glacial);
        CHC.add(ChampionClass.Imperial);
        CHC.add(ChampionClass.Noble);
        CHC.add(ChampionClass.Ninja);
        CHC.add(ChampionClass.Pirate);
        CHC.add(ChampionClass.Wild);
        CHC.add(ChampionClass.Void);
        CHC.add(ChampionClass.Yordle);
        CHC.add(ChampionClass.Assassin);
        CHC.add(ChampionClass.BladeMaster);
        CHC.add(ChampionClass.Brawler);
        CHC.add(ChampionClass.Elementalist);
        CHC.add(ChampionClass.Gunslinger);
        CHC.add(ChampionClass.Knight);
        CHC.add(ChampionClass.Ranger);
        CHC.add(ChampionClass.Shapeshifter);
        CHC.add(ChampionClass.Sorcerer);
        CHC.add(ChampionClass.NON);
        armySize = armySizeInArena+armySizeInBench;
    }

    public boolean isValidBuyMove() {
        return (armySize > championInArena + championInBench) && (championInBench < armySizeInBench);
    }

    public boolean isValidSwap() {
        return  (championInArena < armySizeInArena) && (numSwaps < limitSwaps);
    }

    public void addCoin(int coin) {
        this.coins += coin;
    }

    public int getCoin() {
        return this.coins;
    }

    public boolean checkCoins(int goldCost) {
        if (this.coins >= goldCost)
            return true;
        return false;
    }

    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }

    public int getMyNumber() {
        return this.myNumber;
    }

    public abstract void buildTempStore(ArrayList<Champion> ch) throws FileNotFoundException;

    public int getChampionInArena() {
        return championInArena;
    }

    public ArrayList<Champion> getCurrentChampionInArena() {
        return currentChampionInArena;
    }

    public void setRunning() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    public abstract void start(ArrayList<Champion> arena, ArrayList<Champion> temp) throws Exception;

    public int getLimitSwaps() {
        return limitSwaps;
    }

    public int getNumSwaps() {
        return numSwaps;
    }

    public void setNumSwaps(int numSwaps) {
        this.numSwaps = numSwaps;
    }

    public void setNumSwaps() {
        this.numSwaps++;
    }

    public String displayChampionInfo(Champion ch) {
        String string = "";
        Champion.ChampionAttributes CA = ch.new ChampionAttributes();
        string += "Name : " + CA.getName() + "\n"
                + "Attack damage : " + CA.getAttackDamage() + "\n"
                + "Health : " + CA.getHealth() + "\n"
                + "Cost : " + CA.getGoldCost() + "\n"
                + "Mana : " + CA.getManaStart() + "\n"
                + "Movement speed : " + CA.getMovementSpeed() + "\n"
                + "Position : " + CA.getSquare() + "\n";
        return string;
    }

    public  void cheakLevel(Champion champion,ArrayList<Champion> arena){
        Champion first=null,second=null,third = null;
        int counter=0,c1=0,c2=0,index1=0,index2= 0 ;
        for(int i=0;i<currentChampionInArena.size();i++){
            //if((currentChampionInArena.get(i)).equals(champion))
            Champion.ChampionAttributes CA1 = currentChampionInArena.get(i).new ChampionAttributes();
            Champion.ChampionAttributes CA2 = champion.new ChampionAttributes();
            if(CA1.getName().equals(CA2.getName()) && CA1.getLevel()==CA2.getLevel())
            {
                if(counter == 0){
                    first = currentChampionInArena.get(i);
                    index1 = i;
                    counter++;
                }
                else if(counter == 1)
                {
                    second = currentChampionInArena.get(i);
                    index2 = i;
                    counter++;
                }
                else
                    third = currentChampionInArena.get(i);
            }
        }
        for(int i=0;i<currentChampionInBench.size();i++){
            Champion.ChampionAttributes CA1 = currentChampionInBench.get(i).new ChampionAttributes();
            Champion.ChampionAttributes CA2 = champion.new ChampionAttributes();
            if(CA1.getName().equals(CA2.getName()) && CA1.getLevel()==CA2.getLevel())
            {
                if(counter == 0){
                    first = currentChampionInBench.get(i);
                    counter++;
                    index1 = i;
                    c1 = 1;
                }
                else if(counter == 1)
                {
                    second = currentChampionInBench.get(i);
                    counter++;
                    index2 = i;
                    c2 = 1;
                }
                else
                    third = currentChampionInBench.get(i);
            }
        }
        if(first != null && second != null && third != null){
            if(c2 == 0){
                currentChampionInArena.remove(index2);
                championInArena--;
                removeFromChampionClass(second);
            }
            else{
                currentChampionInBench.remove(index2);
                championInBench--;
            }

            if(c1 == 0){
                currentChampionInArena.remove(index1);
                arena.remove(first);
                championInArena--;
            }
            else
            {
                currentChampionInBench.remove(index1);
                championInBench--;
            }

            removeFromChampionClass(first);
            removeFromChampionClass(second);

            if(third.new ChampionAttributes().getLevel() == 1)
            {
                third.new ChampionAttributes().promot1();
                cheakLevel(third,arena);
            }
            else if(third.new ChampionAttributes().getLevel() == 2)
                third.new ChampionAttributes().promot2();
        }

    }

    public void addToChampionClass(Champion champion){
        int index1,index2,index3;
        Champion.ChampionAttributes CA = champion.new ChampionAttributes();
        index1 = CHC.indexOf(CA.getActiveClass1());
        index2 = CHC.indexOf(CA.getActiveClass2());
        index3 = CHC.indexOf(CA.getActiveClass3());
        championClass[index1]++;
        championClass[index2]++;
        championClass[index3]++;
    }

    public void removeFromChampionClass(Champion champion){
        int index1,index2,index3;
        Champion.ChampionAttributes CA = champion.new ChampionAttributes();
        index1 = CHC.indexOf(CA.getActiveClass1());
        index2 = CHC.indexOf(CA.getActiveClass2());
        index3 = CHC.indexOf(CA.getActiveClass3());
        championClass[index1]--;
        championClass[index2]--;
        championClass[index3]--;
    }

    public void printChampion(){
        System.out.println("************************************");
        for(int i=0;i<20;i++)
            System.out.println(championClass[i]);
        System.out.println("************************************");
    }

    public void setArmySize(int armySize) {
        this.armySize += armySize;
    }

    public void setChampionInArena(int championInArena) {
        this.championInArena += championInArena;
    }

    public void setArmySizeInArena(int armySizeInArena) {
        this.armySizeInArena += armySizeInArena;
    }

    public int[] getChampionClass() {
        return championClass;
    }

    public ArrayList<ChampionClass> getCHC() {
        return CHC;
    }

    public void setCurrentChampionInArena(ArrayList<Champion> currentChampionInArena) {
        this.currentChampionInArena = currentChampionInArena;
    }

    public ArrayList<Champion> getCurrentChampionInBench() {
        return currentChampionInBench;
    }

    public void setCurrentChampionInBench(ArrayList<Champion> currentChampionInBench) {
        this.currentChampionInBench = currentChampionInBench;
    }

    public ArrayList<Champion> getCurrentChampionsInTemporalStore() {
        return currentChampionsInTemporalStore;
    }

    public void setCurrentChampionsInTemporalStore(ArrayList<Champion> currentChampionsInTemporalStore) {
        this.currentChampionsInTemporalStore = currentChampionsInTemporalStore;
    }

    public int getChampionInBench() {
        return championInBench;
    }

    public void setChampionInBench(int championInBench) {
        this.championInBench += championInBench;
    }

    public ArrayList<Champion> getVision(Champion champion,ArrayList<Champion> arena){
        ArrayList<Champion> temp = new ArrayList<Champion>();
        for(int i=0;i<arena.size();i++){
            Champion c = arena.get(i);
            Champion.ChampionAttributes CA1 = c.new ChampionAttributes();
            Champion.ChampionAttributes CA2 = champion.new ChampionAttributes();
            int dis = CA1.getSquare().getDistace(CA2.getSquare());
            if(CA2.getSquare().getType() == SquareType.Grass)
                dis*=2;
            if(CA1.getPlayer() != CA2.getPlayer() && dis <=CA2.getVisonRange()){        //attack range
                temp.add(c);
            }
        }
        return temp;
    }

    public void removeDeadChampion(ArrayList<Champion> arena){
        for(int i =0 ;i<this.currentChampionInArena.size();i++){
            Champion.ChampionAttributes CA = this.currentChampionInArena.get(i).new ChampionAttributes();
            if(CA.getHealth()<=0){
                arena.remove(currentChampionInArena.get(i));
                currentChampionInArena.remove(i);
                championInArena--;
                armySize--;
                i--;
            }
        }
    }


}
