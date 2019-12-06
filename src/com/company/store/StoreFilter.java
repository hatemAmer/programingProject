package com.company.store;
/**
 * Write a description of StoreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.company.champion.Champion;

import java.util.ArrayList;

public class StoreFilter {
    protected StoreFilter decoratedStoreFilter;
    protected InGameStore store;

    public ArrayList<Champion> GetChampionList() throws java.io.FileNotFoundException{
        store = new InGameStore(10);
        store.GenerateList();
        return store.getStore();
    }


}
