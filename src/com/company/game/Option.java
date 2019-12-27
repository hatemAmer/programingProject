package com.company.game;

import com.company.champion.ChampionClass;
import com.company.champion.ChampionClass;
//import com.company.config.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

public  class Option {
    private static Option refToOption;
    private int coinPerRound ;
    private int numberOfRound;
    private int numberOfBots;
    private int numberOfPlayers;
    private int numberOfCopiesInStore;
    private int numberOfChampionInTemp;
    private int limtOfChampionInArena;
    private int limtOfChampionInBench;
    private int limitOfBuyMovePerRound;
    private int limtOfSwaps;
    private int width;
    private int higth;

    private boolean hardLevel;
    private ArrayList<ChampionClass> ActiveClass = new ArrayList<ChampionClass>();

    //ResourceBundle  startPlayConfig = ResourceBundle.getBundle("ChampionClassMap.properties");

    private Option(){
       // startPlayConfig.getString("")
        this.coinPerRound = 2;
        this.numberOfRound = 200;
        this.numberOfBots = 1;
        this.numberOfPlayers = 1;
        this.numberOfCopiesInStore = 1;
        this.numberOfChampionInTemp = 5;
        this.limitOfBuyMovePerRound = 3;
        this.limtOfChampionInArena = 9;
        this.limtOfChampionInBench = 8;
        this.limitOfBuyMovePerRound = 2;
        this.limtOfSwaps = 2;
        this.width = 100;
        this.higth = 100;
        ActiveClass.add(fun1("Demon"));
        this.hardLevel=false;
    }

    public static Option getObject(){
        if(refToOption == null)
            Option.refToOption = new Option();
        return Option.refToOption;
    }

    public int getCoinePerRound() {
        return coinPerRound;
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }

    public int getNumberOfBots() {
        return numberOfBots;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfCopiesInStore() {
        return numberOfCopiesInStore;
    }

    public int getNumberOfChampionInTemp() {
        return numberOfChampionInTemp;
    }

    public static void setRefToOption(Option refToOption) {
        Option.refToOption = refToOption;
    }

    public void setCoinPerRound(int coinPerRound) {
        this.coinPerRound = Math.max(coinPerRound,2);
    }

    public void setNumberOfRound(int numberOfRound) {
        this.numberOfRound = Math.max(numberOfRound,10);
    }

    public void setNumberOfBots(int numberOfBots) {
        this.numberOfBots = Math.max(numberOfBots,0);
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = Math.max(numberOfPlayers,0);
    }

    public void setNumberOfCopiesInStore(int numberOfCopiesInStore) {
        this.numberOfCopiesInStore = Math.max(numberOfCopiesInStore,10);
    }

    public void setNumberOfChampionInTemp(int numberOfChampionInTemp) {
        this.numberOfChampionInTemp = Math.max(numberOfChampionInTemp,3);
    }

    public void AddNewActiveClass(String key){
        ActiveClass.add(fun1(key));
    }

    public void AddNewActiveClass(ChampionClass key){
        ActiveClass.add(key);
    }

    public ArrayList<ChampionClass> getActiveClass() {
        return ActiveClass;
    }

    private ChampionClass fun1(String s){
        switch(s){
            case "Demon":
                return ChampionClass.Demon;
            case "Dragons":
                return ChampionClass.Dragons;
            case "Glacial":
                return ChampionClass.Glacial;
            case "Imperial":
                return ChampionClass.Imperial;
            case "Noble":
                return ChampionClass.Noble;
            case "Ninja":
                return ChampionClass.Ninja;
            case "Pirate":
                return ChampionClass.Pirate;
            case "Wild":
                return ChampionClass.Wild;
            case "Void":
                return ChampionClass.Void;
            case "Yordle":
                return ChampionClass.Yordle;
            case "Assassin":
                return ChampionClass.Assassin;
            case "BladeMaster":
                return ChampionClass.BladeMaster;
            case "Brawler":
                return ChampionClass.Brawler;
            case "Elementalist":
                return ChampionClass.Elementalist;
            case "Gunslinger":
                return ChampionClass.Gunslinger;
            case "Knight":
                return ChampionClass.Knight;
            case "Ranger":
                return ChampionClass.Ranger;
            case "Shapeshifter":
                return ChampionClass.Shapeshifter;
            case "Sorcerer":
                return ChampionClass.Sorcerer;
            default:
                return ChampionClass.NON;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = Math.max(width,1);
    }

    public int getHigth() {
        return higth;
    }

    public void setHigth(int higth) {
        this.higth = Math.max(higth,1);
    }

    public int getLimtOfChampionInArena() {
        return limtOfChampionInArena;
    }

    public void setLimtOfChampionInArena(int limtOfChampionInArena) {
        this.limtOfChampionInArena = Math.max(limtOfChampionInArena,1);
    }

    public int getLimtOfChampionInBench() {
        return limtOfChampionInBench;
    }

    public void setLimtOfChampionInBench(int limtOfChampionInBench) {
        this.limtOfChampionInBench = Math.max(limtOfChampionInBench,1);
    }

    public int getLimtOfSwaps() {
        return limtOfSwaps;
    }

    public void setLimtOfSwaps(int limtOfSwaps) {
        this.limtOfSwaps = Math.max(limtOfSwaps,1);
    }

    public int getLimitOfBuyMovePerRound() {
        return limitOfBuyMovePerRound;
    }

    public void setLimitOfBuyMovePerRound(int limitOfBuyMovePerRound) {
        this.limitOfBuyMovePerRound = Math.max(limitOfBuyMovePerRound,1);
    }

    public boolean isHardLevel() {
        return hardLevel;
    }

    public void setHardLevel(boolean hardLevel) {
        this.hardLevel = hardLevel;
    }

}
