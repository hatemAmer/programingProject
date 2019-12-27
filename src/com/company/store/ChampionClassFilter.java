package com.company.store;

import com.company.champion.Champion;
import com.company.champion.ChampionClass;
import com.company.game.Option;
import com.company.game.Option;
import com.company.store.StoreFilter;
import com.company.champion.Champion;
import com.company.champion.ChampionClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Write a description of ChampionClassFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChampionClassFilter extends StoreFilter {
    public ChampionClassFilter(StoreFilter st) throws IOException, ClassNotFoundException {
        super();
        super.decoratedStoreFilter = st;
    }

    public ArrayList<Champion> GetChampionList() throws FileNotFoundException {
        ArrayList<Champion> temp= super.decoratedStoreFilter.GetChampionList();
        ArrayList<ChampionClass> temp1 = Option.getObject().getActiveClass();
        ArrayList<Champion> tt = new ArrayList<Champion>();
        int size = temp.size();
        for(int i = 0 ; i < size;i++){
            if(!(temp1.indexOf(temp.get(i).new ChampionAttributes().getActiveClass1()) == -1 && temp1.indexOf(temp.get(i).new ChampionAttributes().getActiveClass2()) == -1 && temp1.indexOf(temp.get(i).new ChampionAttributes().getActiveClass3()) == -1))
            {
                tt.add(temp.get(i));
            }
        }
        return  tt;
    }
}
