package com.company.damageCulcolator;

import com.company.Player.Player;
import com.company.champion.Champion;
import com.company.champion.ChampionClass;

import java.io.Serializable;
import java.util.ArrayList;

public class DamageCalculatorFactory implements Serializable {
    private Player player;
    private DamageCalculatorFactory(){}
    public DamageCalculatorFactory(Player player){this.player = player;}
    public void CalculateClass(){
        int PirateIndex = player.getCHC().indexOf(ChampionClass.Pirate);
        int ImperialIndex = player.getCHC().indexOf(ChampionClass.Imperial);
        if(player.getChampionClass()[PirateIndex] >=3)
            player.addCoin(2);
        else if(player.getChampionClass()[ImperialIndex] >= 1){
         //  ArrayList<Champion>champions = player.getCurrentChampionInArena();
         //  for(int i =0 ;i<champions.size();i++){
         //      Champion.ChampionAttributes CA = champions.get(i).new ChampionAttributes();
         //      if(CA.getActiveClass1().equals(ChampionClass.Imperial) || CA.getActiveClass2().equals(ChampionClass.Imperial) || CA.getActiveClass3().equals(ChampionClass.Imperial))
         //          new ImperialClassDamageClaculator(champions.get(i).getCurrentDamageCalculator(),champions.get(i));
         //  }
        }
    }
}
