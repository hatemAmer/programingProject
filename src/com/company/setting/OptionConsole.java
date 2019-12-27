package com.company.setting;

import com.company.game.Option;

import java.util.Scanner;

public class OptionConsole {
    public void start(){

        Scanner scanner = new Scanner(System.in);
        String c="1";
        while (!c.equals("0")){
            System.out.println("1 : Set the number of Players");
            System.out.println("2 : Set the number of Bots");
            System.out.println("3 : Set the number of Rounds");
            System.out.println("4 : Set the Amount of Gold Per Round");
            System.out.println("5 : Set the number of copies in the Store");
            System.out.println("6 : Set the width of arena");
            System.out.println("7 : Set the height of arena");
            System.out.println("8 : Set the number of champion in temporal store");
            System.out.println("9 : Set the size of army in arena");
            System.out.println("10 : Set the size of army in bench");
            System.out.println("11 : Set number of Buy Move Per round");
            System.out.println("12 : Set number of swap per round");
            System.out.println("13 : to Add Active Class");
            System.out.println("14 : set bots level");
            System.out.println("0 : Save and exit");
            c = scanner.next();
            int cc;
                switch (c) {
                    case "1":
                        System.out.println("Set the number of Players");
                        cc = scanner.nextInt();
                        Option.getObject().setNumberOfPlayers(cc);
                        break;
                    case "2":
                        System.out.println("Set the number of Bots");
                        cc = scanner.nextInt();
                        Option.getObject().setNumberOfBots(cc);
                        break;
                    case "3":
                        System.out.println("Set the number of Rounds");
                        cc = scanner.nextInt();
                        Option.getObject().setNumberOfRound(cc);
                        break;
                    case "4":
                        System.out.println("Set the Amount of Gold Per Round");
                        cc = scanner.nextInt();
                        Option.getObject().setCoinPerRound(cc);
                        break;
                    case "5":
                        System.out.println("Set the number of copies in the Store");
                        cc = scanner.nextInt();
                        Option.getObject().setNumberOfCopiesInStore(cc);
                        break;
                    case "6":
                        System.out.println("Set the width of arena");
                        cc = scanner.nextInt();
                        Option.getObject().setWidth(cc);
                        break;
                    case "7":
                        System.out.println("Set the height of arena");
                        cc = scanner.nextInt();
                        Option.getObject().setHigth(cc);
                        break;
                    case "8":
                        System.out.println("Set the number of champion in temporal store");
                        cc = scanner.nextInt();
                        Option.getObject().setNumberOfChampionInTemp(cc);
                        break;
                    case "9":
                        System.out.println("Set the size of army in arena");
                        cc = scanner.nextInt();
                        Option.getObject().setLimtOfChampionInArena(cc);
                        break;
                    case "10":
                        System.out.println("Set the size of army in bench");
                        cc = scanner.nextInt();
                        Option.getObject().setLimtOfChampionInBench(cc);
                        break;
                    case "11":
                        System.out.println("Set number of Buy Move Per round");
                        cc = scanner.nextInt();
                        Option.getObject().setLimitOfBuyMovePerRound(cc);
                        break;
                    case "12":
                        System.out.println("Set number of swap per round");
                        cc = scanner.nextInt();
                        Option.getObject().setLimtOfSwaps(cc);
                        break;
                    case "13":
                        System.out.println("to Add Active Class");
                        String string = scanner.next();
                        Option.getObject().AddNewActiveClass(string);
                        break;
                    case "14":
                        System.out.println("set bots level(0 default level)");
                        cc = scanner.nextInt();
                        if(cc == 0)
                            Option.getObject().setHardLevel(false);
                        else
                            Option.getObject().setHardLevel(true);
                        break;
                }



        }
    }
}
