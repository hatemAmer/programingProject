package com.company.game;


import com.company.champion.Champion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Arena  implements Serializable {
    private ArrayList<Champion> championsInArena = new ArrayList<Champion>();
    public static final Square map[][] = new Square[Option.getObject().getHigth()][Option.getObject().getWidth()];

    public Arena(){
        Random random = new Random();
        int n = Option.getObject().getHigth();
        int m = Option.getObject().getWidth();
        for(int i=0;i<n;i++){
            for(int j =0 ;j<m;j++){
                map[i][j] = new Square(i+1,j+1);
                int t = random.nextInt(4);
                if(t == 1){
                    map[i][j].setType(SquareType.Grass);
                }
                else if(t==2){
                    map[i][j].setType(SquareType.Terrain);
                }
                else if(t==3){
                    map[i][j].setType(SquareType.Water);
                }
                else
                    map[i][j].setType(SquareType.Standard);
            }
        }
    }

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

    public Square[][] getMap() {
        return map;
    }
}
