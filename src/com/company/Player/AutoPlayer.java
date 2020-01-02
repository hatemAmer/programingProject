package com.company.Player;

import com.company.champion.Champion;
import com.company.game.Option;
import com.company.game.Square;
import com.company.move.BasicAttackMove;
import com.company.move.MoveFactory;
import com.company.move.WalkMove;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of AutoPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AutoPlayer extends Player{

    private static boolean level = Option.getObject().isHardLevel();

    public AutoPlayer(){}
    public AutoPlayer(boolean level){
        AutoPlayer.level = level;
    }

    @Override
    public void buildTempStore(ArrayList<Champion> temp) {
        int counter=0;
       // System.out.println(temp);
        if(temp == null)return;
        for(int i=0;i<temp.size();i++){
            if(isValidBuyMove() && this.coins>=temp.get(i).new ChampionAttributes().getGoldCost() && counter < Option.getObject().getLimitOfBuyMovePerRound() && this.championInBench < this.armySizeInBench)
            {
                counter++;
                this.addCoin(-temp.get(i).new ChampionAttributes().getGoldCost());
                this.currentChampionInBench.add(temp.get(i));
                this.addToChampionClass(temp.get(i));
                this.championInBench++;
                new MoveFactory().MakeBuyMove(temp.get(i),this.myNumber);
                /*if(isLevel())
                {
                    Champion ch = temp.get(i);
                    cheakLevel(ch,this.currentChampionInArena);
                }*/
            }
        }
    }

    public void insertToArena(ArrayList<Champion> arena){
        int counter =0 ;
        Random random = new Random();
        for(int i=0;i<this.currentChampionInBench.size();i++){
            Champion champion = currentChampionInBench.get(i);
            if(counter < Option.getObject().getLimtOfSwaps() && this.championInArena < this.armySizeInArena){
                int x = random.nextInt(Option.getObject().getWidth())+1;
                int y = random.nextInt(Option.getObject().getHigth())+1;
                champion.new ChampionAttributes().setSquare(new Square(x,y));
                currentChampionInArena.add(champion);
                this.championInArena++;
                arena.add(champion);
                this.championInBench--;
                currentChampionInBench.remove(i);
            }
        }
    }

    public void putOrder(ArrayList<Champion> arena) throws FileNotFoundException {
        Random random = new Random();
        for(int i=0;i<currentChampionInArena.size();i++){
            ArrayList<Champion> vis = this.getVision(currentChampionInArena.get(i),arena);
            System.out.println(currentChampionInArena.get(i));
            Champion.ChampionAttributes CA = currentChampionInArena.get(i).new ChampionAttributes();
            if(CA.getManaStart() >= CA.getManaCost() && level && vis.size()!=0){
                CA.setMoves(new MoveFactory().MakeAbilityMove(currentChampionInArena.get(i),arena));
                CA.setManaStart(CA.getManaStart()-(int)CA.getManaCost());
//                System.out.println(this.myNumber+":The bots use Ability");
            }
            else if(CA.getHealth()<CA.getMaxHealth()*0.2 && level){
                new MoveFactory().MakeSellMove(currentChampionInArena.get(i));
                this.removeFromChampionClass(currentChampionInArena.get(i));
                currentChampionInArena.remove(i);
                championInArena--;
//                System.out.println(this.myNumber+":The bots sell a champion");
            }
            else if(vis.size() != 0){
                int t = random.nextInt(vis.size());
                currentChampionInArena.get(i).new ChampionAttributes().setMoves(new BasicAttackMove(currentChampionInArena.get(i),vis.get(t)));
                //System.out.println(vis.get(t));
            }else{
                Champion champion = currentChampionInArena.get(i);
                CA = champion.new ChampionAttributes();
                int dis = CA.getMovementSpeed();
                int x=Math.min(Math.max(random.nextInt(2*dis) - dis + CA.getSquare().getX(),1),Option.getObject().getWidth());
                int y=Math.min(Math.max(random.nextInt(2*dis) - dis + CA.getSquare().getY(),1),Option.getObject().getHigth());
                //System.out.println(new Square(x,y));
                CA.setMoves(new WalkMove(champion,new Square(x,y)));
            }
        }
    }

    public void printPlayerInfo(){
        System.out.println("coins:" + this.coins);
        System.out.println("Player #" + this.myNumber + " Turn:Arena " + this.championInArena + " ,Bench: " + this.championInBench+" ,Army:"+this.armySize);
        if(championInArena > armySizeInArena)
            System.err.println(championInArena);
        if(championInBench > armySizeInBench)
            System.err.println(championInBench);
    }

    public void printChampionInArena(){
        for(int i=0;i<this.currentChampionInArena.size();i++){
            System.out.println(this.currentChampionInArena.get(i));
        }
    }

    public static boolean isLevel() {
        return level;
    }

    public static void setLevel(boolean level) {
        AutoPlayer.level = level;
    }

    public ArrayList<Champion> getVision(Champion champion,ArrayList<Champion> arena){
        ArrayList<Champion> temp = new ArrayList<Champion>();
        for(int i=0;i<arena.size();i++){
            Champion c = arena.get(i);
            Champion.ChampionAttributes CA1 = c.new ChampionAttributes();
            Champion.ChampionAttributes CA2 = champion.new ChampionAttributes();
            int dis = CA1.getSquare().getDistace(CA2.getSquare());
            if(CA1.getPlayer() != CA2.getPlayer() && dis <=CA2.getAttackRange()){
                temp.add(c);
            }
        }
        return temp;
    }

    @Override
    public void start(ArrayList<Champion> arena, ArrayList<Champion> temp) throws Exception {
        printPlayerInfo();
        if(temp!=null)
            this.buildTempStore(temp);
        insertToArena(arena);
       // printChampionInArena();
        putOrder(arena);
        Thread.sleep(100);
    }

}