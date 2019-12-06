package com.company.store;

import com.company.champion.Champion;

import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of TemporalStoreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TemporalStoreFilter extends StoreFilter{
    int sizeOfTemp;

    public TemporalStoreFilter(){sizeOfTemp = 5;}
    public TemporalStoreFilter(int x,StoreFilter st){
        this.decoratedStoreFilter = st;
        this.sizeOfTemp = x;
    }
    public ArrayList<Champion> GetChampionList() throws java.io.FileNotFoundException{
        ArrayList<Champion> temp1 = super.GetChampionList(),temp = new ArrayList<Champion>();
        for(int i=0 ; i<temp1.size();i++)
        {
            Champion.ChampionAttributes ca = temp1.get(i).new ChampionAttributes();
            if(ca.getPlayer() != 0 || ca.getHealth() <= 0){
                temp1.remove(i);
                i--;
            }
        }

        Random r= new Random();
        int x = this.sizeOfTemp,t;

        while(x !=0){
            t = r.nextInt(temp1.size());
            Champion.ChampionAttributes ca = temp1.get(t).new ChampionAttributes();
            if(ca.getPlayer() != 0 || ca.getHealth() <= 0)
                continue;
            temp.add(temp1.get(t));
            x--;
        }
        temp.get(0).print();
        temp.get(1).print();
        temp.get(2).print();
        temp.get(3).print();
        temp.get(4).print();
        return temp;
    }
}
