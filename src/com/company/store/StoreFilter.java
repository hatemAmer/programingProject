package com.company.store;
/**
 * Write a description of StoreFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.company.Player.GUIPlayer;
import com.company.Player.Player;
import com.company.champion.Champion;

import java.io.*;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;

public class StoreFilter implements Serializable {
    protected StoreFilter decoratedStoreFilter;
    protected InGameStore store;

    public StoreFilter() throws IOException, ClassNotFoundException {
        if(InGameStore.refToStore==null)
         store = InGameStore.getObject();
        else
            store = InGameStore.refToStore;
//        File file = new File("store.txt");
//            if (file.length() == 0) {
//                try {
//                    store = InGameStore.getObject();
//
//                    FileOutputStream f = new FileOutputStream(file);
//                    ObjectOutputStream o = new ObjectOutputStream(f);
//                    // Write objects to file
//                    o.writeObject(InGameStore.getObject().getStore());
//                    o.close();
//                    f.close();
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            } else {
//                FileInputStream fi = new FileInputStream(file);
//                ObjectInputStream oi = new ObjectInputStream(fi);
//                ArrayList<Champion> champions = (ArrayList<Champion>) oi.readObject();
//                store=new InGameStore(champions);
//                //store.setStore() ;
//                oi.close();
//                fi.close();
//        }

    }

    public ArrayList<Champion> GetChampionList() throws FileNotFoundException {
        return store.getStore();
    }
}
