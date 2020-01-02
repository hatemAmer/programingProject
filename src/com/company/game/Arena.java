package com.company.game;


import com.company.champion.Champion;

import java.io.Serializable;
import java.util.ArrayList;

public class Arena  implements Serializable {
    private ArrayList<Champion> championsInArena = new ArrayList<Champion>();

    private ArrayList<Square> squares = new ArrayList<Square>();

    public void GenerateList(ArrayList<Champion> champions) {
        int n = champions.size();
        for (int i = 0; i < n; i++) {
            addToList(champions.get(i));
        }
    }

    public void addToList(Champion champion) {
        this.championsInArena.add(champion);
    }

    public void deleteFromList(Champion champion) {
        int ind = searchInList(champion);
        if (ind != -1)
            championsInArena.remove(ind);
    }

    public void deleteFromList(String name, Square square, int player, int level) {
        Champion champion = searchInList(name, square, player, level);
        if (champion != null)
            championsInArena.remove(champion);
    }

    public int searchInList(Champion champion) {
        int n = championsInArena.size();
        Champion.ChampionAttributes CA1;
        Champion.ChampionAttributes CA2 = champion.new ChampionAttributes();
        for (int i = 0; i < n; i++) {
            int count = 0;
            CA1 = championsInArena.get(i).new ChampionAttributes();
            if (CA1.getSquare().getX() == CA2.getSquare().getX())
                if (CA1.getSquare().getY() == CA2.getSquare().getY())
                    count++;
            if (CA1.getName() == CA2.getName())
                count++;
            if (CA1.getPlayer() == CA2.getPlayer())
                count++;
            if (count == 3)
                return i;
        }
        return -1;
    }

    public Champion searchInList(Square square) {
        int n = championsInArena.size();
        Champion.ChampionAttributes CA1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            CA1 = championsInArena.get(i).new ChampionAttributes();
            if (CA1.getSquare().getX() == square.getX())
                if (CA1.getSquare().getY() == square.getY())
                    count++;
            if (count == 1)
                return championsInArena.get(i);
        }
        return null;
    }

    public Champion searchInList(String name, Square square, int player, int level) {
        int n = championsInArena.size();
        Champion.ChampionAttributes CA1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            CA1 = championsInArena.get(i).new ChampionAttributes();
            if (CA1.getSquare().getX() == square.getX())
                if (CA1.getSquare().getY() == square.getY())
                    count++;
            if (CA1.getName() == name)
                count++;
            if (CA1.getPlayer() == player)
                count++;
            if (CA1.getLevel() == level)
                if (count == 4)
                    return championsInArena.get(i);
        }
        return null;
    }

    public ArrayList<Champion> getChampionsInArena() {
        return championsInArena;
    }

    public Champion getChampionInArena(int ind) {
        return championsInArena.get(ind);
    }

}
