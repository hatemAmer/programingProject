package com.company.Player;

import com.company.champion.Champion;
import com.company.game.Option;
import com.company.game.Square;
import com.company.move.BasicAttackMove;
import com.company.move.MoveFactory;
import com.company.move.WalkMove;
import com.company.Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of ConsolePlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConsolePlayer extends Player{

    public void printPlayerInfo(){
        System.out.println("coins:" + this.coins);
        System.out.println("Player #" + this.myNumber + " Turn: Arena:" + this.championInArena + " , Bench:" + this.championInBench + "Army:"+this.armySize);
    }

    public void printChampionInArena(){
        System.out.println("--------------------------current champion in arena-----------------------------------");
        printArray(this.currentChampionInArena);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void printChampionInBench(){
        System.out.println("--------------------------current champion in bench-----------------------------------");
        this.printArray(this.currentChampionInBench);
    }

    public void championOrder(Champion c,ArrayList<Champion> arena){
        ArrayList<Champion> visionRange = new ArrayList<Champion>();
        Scanner scanner = new Scanner(System.in);

        String cc = "1";
        while (!cc.equals("0")){
            System.out.println("1 : Attack target");
            System.out.println("2 : Walk move");
            System.out.println("3 : Get Vision");
            System.out.println("4 : Use Ability");
            System.out.println("5 : Back to Bench");
            System.out.println("6 : Sell Champion");
            System.out.println("0 : to exit");
            cc = scanner.next();
            int ccc;
            switch (cc){
                case "1":
                    System.out.println("Attack target");
                    System.out.println("Enter target ID:");
                    if(visionRange.size()==0)
                    {
                        visionRange = this.getVision(c,arena);
                        System.out.println("*******************Vision Range**********************");
                        this.printArray(visionRange);
                        System.out.println("*****************************************************");
                    }
                    ccc = scanner.nextInt();
                    if(ccc >= visionRange.size() || ccc < 0)
                        break;
                    c.new ChampionAttributes().setMoves(new BasicAttackMove(c,visionRange.get(ccc)));
                    System.out.println("done");
                    break;
                case "2":
                    System.out.println("Walk move");
                    System.out.println("Enter x & y cordinates");
                    int x = scanner.nextInt(),y=scanner.nextInt();
                    c.new ChampionAttributes().setMoves(new WalkMove(c,new Square(x,y)));
                    break;
                case "3":
                    System.out.println("*******************Vision Range**********************");
                    visionRange = this.getVision(c,arena);
                    printArray(visionRange);
                    System.out.println("*****************************************************");
                    break;
                case "4":
                    System.out.println("Use Ability");
                    if(c.new ChampionAttributes().getManaStart() >= c.new ChampionAttributes().getManaCost())
                    {
                        System.err.println((c.new ChampionAttributes().getManaStart()-(int)c.new ChampionAttributes().getManaCost()));
                        c.new ChampionAttributes().setManaStart((c.new ChampionAttributes().getManaStart()-(int)c.new ChampionAttributes().getManaCost()));
                        c.new ChampionAttributes().setMoves(new MoveFactory().MakeAbilityMove(c,arena));
                        System.out.println("done");
                    }else
                        System.err.println("Sorry Ability Not Ready yet,try to Attack some enimy");
                    break;
                case "5":
                    System.out.println("Back to Bench");
                    if(championInBench<armySizeInBench && this.numSwaps<this.limitSwaps)
                    {
                        currentChampionInBench.add(c);
                        championInBench++;
                        championInArena--;
                        currentChampionInArena.remove(c);
                        numSwaps++;
                        System.out.println("done");
                    }
                    else
                        System.out.println("not completed");
                    break;
                case "6":
                    System.out.println("Sell Champion");
                    this.addCoin(c.new ChampionAttributes().getGoldCost());
                    this.removeFromChampionClass(c);
                    this.championInArena--;
                    new MoveFactory().MakeSellMove(c);
                    this.currentChampionInArena.remove(c);
                    System.out.println("done");
                    break;
            }

        }
    }

    public void GetOrder(ArrayList<Champion> arena, ArrayList<Champion> temp){

        String c = "1";
        Scanner scanner = new Scanner(System.in);


        while (!c.equals("0")){
            if(Thread.interrupted())
                return;
            System.out.println("1 : To Buy A Champion");
            System.out.println("2 : To Sell A Champion");
            System.out.println("3 : To Select A Champion From Arena");
            System.out.println("4 : To Add New Champion To Arena");
            c= scanner.next();
            int cc;
            switch (c){
                case "1":
                    System.out.println("To Buy A Champion,Enter Champion ID:");
                    cc=scanner.nextInt();
                    if(cc<temp.size() && isValidBuyMove() && this.coins >= temp.get(cc).new ChampionAttributes().getGoldCost() && cc>=0 && Option.getObject().getNumberOfChampionInTemp()-temp.size()<Option.getObject().getLimitOfBuyMovePerRound()){
                        this.addToChampionClass(temp.get(cc));
                        new MoveFactory().MakeBuyMove(temp.get(cc),this.myNumber);
                        this.currentChampionInBench.add(temp.get(cc));
                        this.championInBench++;
                        this.armySize++;
                        this.addCoin(-temp.get(cc).new ChampionAttributes().getGoldCost());
                        this.cheakLevel(temp.get(cc),arena);
                        addToChampionClass(temp.get(cc));
                        temp.remove(cc);
                        printChampionInBench();
                        System.out.println("done");
                    }
                    else
                        System.out.println("Buy Move Not Completed");
                    break;
                case "2":
                    System.out.println("To Sell A Champion");
                    cc=scanner.nextInt();
                    if(cc<0 || cc>currentChampionInBench.size())
                    {
                        System.out.println("not completed");
                        break;
                    }
                    this.removeFromChampionClass(currentChampionInBench.get(cc));
                    this.addCoin(currentChampionInBench.get(cc).new ChampionAttributes().getGoldCost());
                    this.championInBench--;
                    new MoveFactory().MakeSellMove(currentChampionInBench.get(cc));
                    this.currentChampionInBench.remove(currentChampionInBench.get(cc));
                    System.out.println("done");
                    break;
                case "3":
                    System.out.println("To Select A Champion From Arena");
                    System.out.println("Enter Champion ID:");
                    cc = scanner.nextInt();
                    if(cc<0 || cc>=currentChampionInArena.size())
                    {
                        System.out.println("not completed");
                        break;
                    }
                    championOrder(this.currentChampionInArena.get(cc),arena);
                    break;
                case "4":
                    System.out.println("To Add New Champion To Arena");
                    cc=scanner.nextInt();
                    if(cc<0 || cc>currentChampionInBench.size() || currentChampionInBench.size()==0 || numSwaps>=limitSwaps)
                    {
                        System.out.println("not completed");
                        break;
                    }
                    this.currentChampionInArena.add(this.currentChampionInBench.get(cc));
                    System.out.println("Enter x & y corinates:");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    x=Math.min(Math.max(x,1),Option.getObject().getWidth());
                    y=Math.min(Math.max(y,1),Option.getObject().getHigth());
                    arena.add(this.currentChampionInBench.get(cc));
                    this.currentChampionInBench.get(cc).new ChampionAttributes().setSquare(new Square(x,y));
                    this.currentChampionInBench.remove(cc);
                    this.championInBench--;
                    this.championInArena++;
                    printChampionInArena();
                    numSwaps++;
                    System.out.println("done");
                    break;
            }
        }

    }

    @Override
    public void buildTempStore(ArrayList<Champion> ch) {
        System.out.println("***************************Temporal Store*********************************");
        if(ch != null)
            printArray(ch);
        System.out.println("*************************************************************************************");
    }


    @Override
    public void start(ArrayList<Champion> arena, ArrayList<Champion> temp){
        removeDeadChampion(arena);
       // printArena();
        printPlayerInfo();
        printChampionInArena();
        printChampionInBench();
        buildTempStore(temp);
        GetOrder(arena,temp);
        notifyAll();
    }


    private void printArena(){
        for (int i = 1; i<= Option.getObject().getWidth(); i++){
            for(int j=1;j<=Option.getObject().getHigth();j++){
                int z;
                for(z=0;z<currentChampionInArena.size();z++)
                {
                    if(currentChampionInArena.get(z).new ChampionAttributes().getSquare().getX() == i && currentChampionInArena.get(z).new ChampionAttributes().getSquare().getY() == j)
                        break;
                }
                if(z == currentChampionInArena.size())
                    System.out.print("####");
                else
                {
                    Champion.ChampionAttributes CA = currentChampionInArena.get(z).new ChampionAttributes();
                    System.out.print("P"+CA.getPlayer()+CA.getName().substring(0,2));
                }
            }
            System.out.println();
        }
    }
    private void printArray(ArrayList<Champion>champions) {
        for (int i = 0; i < champions.size(); i++) {
            System.out.println(i + " : " + champions.get(i));
        }
    }

}
