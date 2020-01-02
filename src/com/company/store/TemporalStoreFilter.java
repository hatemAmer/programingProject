package com.company.store;
/**
 * Write a description of TemporalStoreFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.company.champion.Champion;
import com.company.game.Option;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class TemporalStoreFilter extends StoreFilter implements Serializable {

    private TemporalStoreFilter() throws IOException, ClassNotFoundException {
        //super();
    }

    public TemporalStoreFilter(StoreFilter st) throws IOException, ClassNotFoundException {
        //super();
        super.decoratedStoreFilter = st;
    }

    public ArrayList<Champion> GetChampionList() throws FileNotFoundException {
        ArrayList<Champion> temp1 = super.decoratedStoreFilter.GetChampionList(),
                temp = new ArrayList<Champion>();
        Random r = new Random();
        int x = Option.getObject().getNumberOfChampionInTemp(), t;
        int counter = 0;
        if (temp1.size() > 0)
            while (x != 0 && x <= temp1.size()) {
                t = r.nextInt(temp1.size());
                Champion.ChampionAttributes ca = temp1.get(t).new ChampionAttributes();
                if (counter == 1000)
                    break;
                if (ca.getPlayer() != 0 || ca.getHealth() <= 0 || temp1.get(t) == null) {
                    counter++;
                    continue;
                }
                if (temp.indexOf(temp1.get(t)) == -1) {
                    temp.add(temp1.get(t));
                    x--;
                }

            }

        if (temp.size() == 0 && temp1.size() != 0) {
            for (int i = 0; i < temp1.size(); i++) {
                Champion.ChampionAttributes ca = temp1.get(i).new ChampionAttributes();
                if (ca.getPlayer() == 0 && ca.getHealth() > 0 && temp1.get(i) != null) {
                    temp.add(temp1.get(i));
                }
            }
        }
        if (temp.size() == 0) return null;
        return temp;
    }
}
