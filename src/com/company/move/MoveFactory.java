package com.company.move;

import com.company.champion.Champion;
import com.company.move.Ability.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MoveFactory implements Serializable {
    public void MakeBuyMove(Champion src, int playerNumber){
         new BuyMove(src,playerNumber);
    }

    public void MakeSellMove(Champion src){
        new SellMove(src);
    }

    public Move MakeAbilityMove(Champion src, ArrayList<Champion> srcarena){
        Champion.ChampionAttributes CA = src.new ChampionAttributes();
        switch (CA.getName()){
            case "Aatrox":
                return new AatroxAbilityMove(src,srcarena);
            case "Ahri":
                return new AhriAbilityMove(src,srcarena);
            case "Akali":
                return new AkaliAbilityMove(src,srcarena);
            case "Anivia":
                return new AniviaAbilityMove(src,srcarena);
            case "Ashe":
                return new AsheAbilityMove(src,srcarena);
            case "Brand":
                return new BrandAbilityMove(src,srcarena);
            case "Chogath":
                return new ChogathAbilityMove(src,srcarena);
            case "Darius":
                return new DariusAbilityMove(src,srcarena);
            case "Draven":
                return new DravenAbilityMove(src,srcarena);
            case "Evelynn":
                return new EvelynnAbilityMove(src,srcarena);
            case "Fiora":
                return new FioraAbilityMove(src,srcarena);
            case "Garen":
                return new GarenAbilityMove(src,srcarena);
        }
        return null;
    }
}
