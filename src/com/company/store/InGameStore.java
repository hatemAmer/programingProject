package com.company.store;

import com.company.champion.Champion;
import com.company.champion.ChampionClass;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class InGameStore {
    private ArrayList<Champion> store;
    private int numberOfCopies;


    public InGameStore(int num){
        this.numberOfCopies = num;
        store = new ArrayList<Champion>();
    }



    public void GenerateList() throws java.io.FileNotFoundException{
        Scanner scanner = new Scanner(new File("D:\\IT_engnering\\java_project\\test2\\Appendix1.txt"));
        Champion t= new Champion();
        Champion.ChampionAttributes CA = t.new ChampionAttributes();
        int count = 1;
        // while(scanner.hasNextLine()){
        while(scanner.hasNext()){

            String s = scanner.next(); // get the championSrc name
            CA.setName(s);

            s = scanner.next();         //get the active class 1
            CA.setActiveClass1(fun1(s));

            s = scanner.next();         //get the active class 2
            CA.setActiveClass2(fun1(s));

            s = scanner.next();         //get the active class 3
            CA.setActiveClass3(fun1(s));

            int num = scanner.nextInt(); //get GoldCost
            CA.setGoldCost(num);

            num = scanner.nextInt();    // get Health
            CA.setHealth(num);

            double info;
            info = scanner.nextDouble(); //get Armor
            CA.setArmor(info);

            info = scanner.nextDouble();//get magic resist
            CA.setMagicResist(info);

            num = scanner.nextInt();    //get Vison Range
            CA.setVisonRange(num);

            num = scanner.nextInt();    //get Attack Range
            CA.setAttackRange(num);

            num = scanner.nextInt();    //get Attack Damage
            CA.setAttackDamage(num);

            num = scanner.nextInt();    //get Movement Speed
            CA.setMovementSpeed(num);

            info = scanner.nextDouble();    //get Critical strike chance
            CA.setCriticalStrikeChance(info);

            info = scanner.nextDouble();    //get Critical strike damage
            CA.setCriticalStrikeDamage(info);

            num = scanner.nextInt();    //get Mana Start
            CA.setManaStart(num);

            info = scanner.nextDouble();    //get Mana Cost
            CA.setManaCost(info);

            for(int i=0;i<numberOfCopies;i++)
                store.add(new Champion(CA.getGoldCost(),CA.getHealth(),CA.getVisonRange(),
                        CA.getAttackRange(),CA.getAttackDamage(),CA.getMovementSpeed(),
                        CA.getManaStart(),CA.getManaCost(),CA.getArmor(),CA.getMagicResist(),
                        CA.getCriticalStrikeChance(),CA.getCriticalStrikeDamage(),CA.getName(),count,CA.getActiveClass1()
                        ,CA.getActiveClass2(),CA.getActiveClass3()));
            count++;
            //System.out.println(CA.getName());
        }
        scanner.nextLine();
        //}

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
            case "Blade_Master":
                return ChampionClass.Blade_Master;
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


    public ArrayList<Champion> getStore() throws java.io.FileNotFoundException{
        return this.store;
    }

    public void setNumberOfCopies(int num){this.numberOfCopies = num;}

    public int getNumberOfCopies(){return this.numberOfCopies;}

}
