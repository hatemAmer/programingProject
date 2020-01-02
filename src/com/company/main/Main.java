package com.company.main;

import com.company.game.Game;
import com.company.setting.OptionConsole;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.company.game.*;
import java.util.Scanner;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2, scene3, scene4;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Interface anInterface = new Interface(primaryStage, scene1, scene2, scene3, scene4);
    }

    public static void main(String[] args) throws Exception {

        Option option = Option.getObject();
        option.setCoinPerRound(40);
        option.setNumberOfChampionInTemp(5);
        option.setNumberOfCopiesInStore(10);
        option.setNumberOfPlayers(1);
        option.setNumberOfBots(1);
        option.setNumberOfRound(8000000);
        option.AddNewActiveClass("Demon");
        option.AddNewActiveClass("Imperial");
        option.AddNewActiveClass("Dragons");
        option.AddNewActiveClass("Glacial");
        option.AddNewActiveClass("Noble");
        option.AddNewActiveClass("Noble");
        option.AddNewActiveClass("Pirate");
        option.AddNewActiveClass("Wild");
        option.AddNewActiveClass("Yordle");
        option.AddNewActiveClass("Assassin");
        option.AddNewActiveClass("BladeMaster");
        option.AddNewActiveClass("Brawler");
        option.AddNewActiveClass("Elementalist");
        option.AddNewActiveClass("Gunslinger");
        option.AddNewActiveClass("Knight");
        option.AddNewActiveClass("Ranger");
        option.AddNewActiveClass("Shapeshifter");
        option.AddNewActiveClass("Sorcerer");
        option.setHigth(5);
        option.setWidth(5);
        option.setLimtOfSwaps(3);
        option.setLimitOfBuyMovePerRound(5);
        option.setLimtOfChampionInArena(9);
        option.setLimtOfChampionInBench(8);
        option.setHardLevel(false);

        String ch = "1";
        while (!ch.equals("0")) {
            System.out.println("1 : For GUI player");
            System.out.println("2 : For Console Player");
            Scanner scanner = new Scanner(System.in);
            ch = scanner.next();
            switch (ch) {
                case "1":
                    launch(args);
                    return;
                case "2":
                    new OptionConsole().start();
                    Game game = new Game();
                    Game.RoundManager RM = game.new TacticalChaosTM();
                    RM.RunTurn();
            }
        }


        //     ArrayList<Champion> temp = (new TemporalStoreFilter(new ChampionClassFilter(new StoreFilter()))).GetChampionList();
        //  for(int i =0 ; i<temp.size();i++)
        //     System.out.println(i + " : " + temp.get(i));

    }

}
