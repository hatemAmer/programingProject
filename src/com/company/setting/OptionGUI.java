package com.company.setting;

import com.company.champion.ChampionClass;
import com.company.game.Option;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionGUI {
    Stage window;
    Scene scene1, scene2;
    Pane center, bottom;
    VBox listOptions1, listOptions2 , listOption3;
    Button submitButton;
    Button backButton;
    TextField fieldNumOfPlayer;
    TextField fieldNumOfBots;
    TextField fieldNumOfRounds;
    TextField fieldNumOfCoinePerRound;
    TextField fieldNumOfCopies;
    TextField fieldWidth;
    TextField fieldHeight;
    TextField fieldNumInTemp;
    TextField fieldChampionInArena;
    TextField fieldChampionInBench;
    TextField fieldNumOfBuyMove;
    TextField fieldNumOfSwap;
    int startLabelX = 25;
    int startLabelY = 325;
    CheckBox Boxs[] = new CheckBox[20];
    public OptionGUI(Stage window, Scene scene1, Scene scene2) {
        this.window = window;
        this.scene1 = scene1;
        this.scene2 = scene2;
        setScene3();
    }

    public void setScene3() {
        setCenter();
        setBottom();

        BorderPane layout = new BorderPane();

        layout.setCenter(center);
        layout.setBottom(bottom);

        scene1 = new Scene(layout, 600, 525);
        scene1.getStylesheets().add("cssFiles/styles.css");
        window.setTitle("Options");
        window.setScene(scene1);
        window.setX(370);
        window.setY(140);
        window.show();
    }


    public void setCenter() {
        center = new Pane();
        setListOptions1();
        setListOptions2();
        setListOptions3();

        listOptions1.setLayoutX(50);
        listOptions2.setLayoutX(350);
        listOption3.setLayoutY(220);
        center.getChildren().addAll(listOptions1,listOptions2,listOption3);
    }

    public void setListOptions1() {
        listOptions1 = new VBox();
        listOptions1.setMinHeight(300);

        Label NumOfPlayer = new Label("Number of player : ");
        fieldNumOfPlayer = new TextField();
        fieldNumOfPlayer.setPromptText("Only integer");
        fieldNumOfPlayer.setMaxWidth(250);

        Label NumOfBots = new Label("Number of bots : ");
        fieldNumOfBots = new TextField();
        fieldNumOfBots.setPromptText("Only integer");
        fieldNumOfBots.setMaxWidth(200);

        Label NumOfRounds = new Label("Number of round : ");
        fieldNumOfRounds = new TextField();
        fieldNumOfRounds.setPromptText("Only integer");
        fieldNumOfRounds.setMaxWidth(200);

        Label NumOfCoinsPerRound = new Label("Number of coins per round : ");
        fieldNumOfCoinePerRound = new TextField();
        fieldNumOfCoinePerRound.setPromptText("Only integer");
        fieldNumOfCoinePerRound.setMaxWidth(200);

        Label NumOfCopies = new Label("Number of copies in store : ");
        fieldNumOfCopies = new TextField();
        fieldNumOfCopies.setPromptText("Only integer");
        fieldNumOfCopies.setMaxWidth(200);
        fieldNumOfCopies.setLayoutX(300);

        listOptions1.getChildren().addAll(NumOfPlayer, fieldNumOfPlayer,
                NumOfBots, fieldNumOfBots,
                NumOfRounds, fieldNumOfRounds,
                NumOfCoinsPerRound, fieldNumOfCoinePerRound,
                NumOfCopies, fieldNumOfCopies
        );





    }

    public void setListOptions2() {
        listOptions2 = new VBox();
        listOptions2.setMinHeight(300);

        Label NumOfPlayer = new Label("Width : ");
        fieldWidth = new TextField();
        fieldWidth.setPromptText("Only integer");
        fieldWidth.setMaxWidth(200);

        Label NumOfBots = new Label("Height : ");
        fieldHeight = new TextField();
        fieldHeight.setPromptText("Only integer");
        fieldHeight.setMaxWidth(200);

        Label NumOfRounds = new Label("Number of champion in temporal store : ");
        fieldNumInTemp = new TextField();
        fieldNumInTemp.setPromptText("Only integer");
        fieldNumInTemp.setMaxWidth(200);

        Label NumOfCoinsPerRound = new Label("Number of army size in Arena : ");
        fieldChampionInArena = new TextField();
        fieldChampionInArena.setPromptText("Only integer");
        fieldChampionInArena.setMaxWidth(200);

        Label NumOfPlanningRounds = new Label("Number of army size in Bench : ");
        fieldChampionInBench = new TextField();
        fieldChampionInBench.setPromptText("Only integer");
        fieldChampionInBench.setMaxWidth(200);

        Label NumOfCopies = new Label("Number of Buy Move Per Round : ");
        fieldNumOfBuyMove = new TextField();
        fieldNumOfBuyMove.setPromptText("Only integer");
        fieldNumOfBuyMove.setMaxWidth(200);
        fieldNumOfBuyMove.setLayoutX(300);

        Label NumOfSwaps = new Label("Number of Swaps : ");
        fieldNumOfSwap = new TextField();
        fieldNumOfSwap.setPromptText("Only integer");
        fieldNumOfSwap.setMaxWidth(200);
        fieldNumOfSwap.setLayoutX(300);

        listOptions2.getChildren().addAll(NumOfPlayer, fieldWidth,
                NumOfBots, fieldHeight,
                NumOfRounds, fieldNumInTemp,
                NumOfCoinsPerRound, fieldChampionInArena,
                NumOfPlanningRounds, fieldChampionInBench,
                NumOfCopies, fieldNumOfBuyMove,
                NumOfSwaps,fieldNumOfSwap
        );

    }

    public void setListOptions3(){
        listOption3 = new VBox();
        listOptions1.setMinHeight(100);

        Label demonLabel = new Label("Demon:");
        Boxs[0] = new CheckBox();
        demonLabel.setLayoutX(startLabelX);
        demonLabel.setLayoutY(startLabelY);
        Boxs[0].setLayoutX(startLabelX+70);
        Boxs[0].setLayoutY(startLabelY);


        Label RangerLabel = new Label("Ranger:");
        Boxs[1] = new CheckBox();
        RangerLabel.setLayoutX(startLabelX);
        RangerLabel.setLayoutY(startLabelY+25);
        Boxs[1].setLayoutX(startLabelX+70);
        Boxs[1].setLayoutY(startLabelY+25);


        Label DragonsLabel = new Label("Dragons:");
        Boxs[2] = new CheckBox();
        DragonsLabel.setLayoutX(startLabelX);
        DragonsLabel.setLayoutY(startLabelY+50);
        Boxs[2].setLayoutX(startLabelX+70);
        Boxs[2].setLayoutY(startLabelY+50);


        Label GlacialLabel = new Label("Glacial:");
        Boxs[3] = new CheckBox();
        GlacialLabel.setLayoutX(startLabelX);
        GlacialLabel.setLayoutY(startLabelY + 75);
        Boxs[3].setLayoutX(startLabelX+70);
        Boxs[3].setLayoutY(startLabelY+75);

        Label ImperialLabel = new Label("Imperial:");
        Boxs[4] = new CheckBox();
        ImperialLabel.setLayoutX(startLabelX);
        ImperialLabel.setLayoutY(startLabelY+100);
        Boxs[4].setLayoutX(startLabelX+70);
        Boxs[4].setLayoutY(startLabelY+100);

        Label NobleLabel = new Label("Nobel:");
        Boxs[5] = new CheckBox();
        NobleLabel.setLayoutX(startLabelX);
        NobleLabel.setLayoutY(startLabelY+125);
        Boxs[5].setLayoutX(startLabelX+70);
        Boxs[5].setLayoutY(startLabelY+125);

        startLabelX+=125;

        Label NinjaLabel = new Label("Ninja:");
        Boxs[6] = new CheckBox();
        NinjaLabel.setLayoutX(startLabelX);
        NinjaLabel.setLayoutY(startLabelY);
        Boxs[6].setLayoutX(startLabelX+70);
        Boxs[6].setLayoutY(startLabelY);

        Label PiratesLabel = new Label("Pirates:");
        Boxs[7] = new CheckBox();
        PiratesLabel.setLayoutX(startLabelX);
        PiratesLabel.setLayoutY(startLabelY+25);
        Boxs[7].setLayoutX(startLabelX+70);
        Boxs[7].setLayoutY(startLabelY+25);

        Label WildLabel = new Label("Wild:");
        Boxs[8] = new CheckBox();
        WildLabel.setLayoutX(startLabelX);
        WildLabel.setLayoutY(startLabelY+50);
        Boxs[8].setLayoutX(startLabelX+70);
        Boxs[8].setLayoutY(startLabelY+50);

        Label VoidLabel = new Label("Void:");
        Boxs[9] = new CheckBox();
        VoidLabel.setLayoutX(startLabelX);
        VoidLabel.setLayoutY(startLabelY+75);
        Boxs[9].setLayoutX(startLabelX+70);
        Boxs[9].setLayoutY(startLabelY+75);

        Label YordleLabel = new Label("Yordle:");
        Boxs[10] = new CheckBox();
        YordleLabel.setLayoutX(startLabelX);
        YordleLabel.setLayoutY(startLabelY+100);
        Boxs[10].setLayoutX(startLabelX+70);
        Boxs[10].setLayoutY(startLabelY+100);

        Label AssassinLabel = new Label("Assassin:");
        Boxs[11] = new CheckBox();
        AssassinLabel.setLayoutX(startLabelX);
        AssassinLabel.setLayoutY(startLabelY+125);
        Boxs[11].setLayoutX(startLabelX+70);
        Boxs[11].setLayoutY(startLabelY+125);

        startLabelX+=125;

        Label BladeMasterLabel = new Label("BladeMaster:");
        Boxs[12] = new CheckBox();
        BladeMasterLabel.setLayoutX(startLabelX);
        BladeMasterLabel.setLayoutY(startLabelY);
        Boxs[12].setLayoutX(startLabelX+70);
        Boxs[12].setLayoutY(startLabelY);

        Label BrawlerLabel = new Label("Brawler");
        Boxs[13] = new CheckBox();
        BrawlerLabel.setLayoutX(startLabelX);
        BrawlerLabel.setLayoutY(startLabelY+25);
        Boxs[13].setLayoutX(startLabelX+70);
        Boxs[13].setLayoutY(startLabelY+25);
        
        Label ElementalistLabel = new Label("Elementalist:");
        Boxs[14] = new CheckBox();
        ElementalistLabel.setLayoutX(startLabelX);
        ElementalistLabel.setLayoutY(startLabelY+50);
        Boxs[14].setLayoutX(startLabelX+70);
        Boxs[14].setLayoutY(startLabelY+50);

        Label GunslingerLabel = new Label("Gunslinger:");
        Boxs[15] = new CheckBox();
        GunslingerLabel.setLayoutX(startLabelX);
        GunslingerLabel.setLayoutY(startLabelY+75);
        Boxs[15].setLayoutX(startLabelX+70);
        Boxs[15].setLayoutY(startLabelY+75);

        Label KnightLabel = new Label("Knight:");
        Boxs[16] = new CheckBox();
        KnightLabel.setLayoutX(startLabelX);
        KnightLabel.setLayoutY(startLabelY+100);
        Boxs[16].setLayoutX(startLabelX+70);
        Boxs[16].setLayoutY(startLabelY+100);

        Label ShapeshifterLabel  =new Label("Shapeshifter:");
        Boxs[17] = new CheckBox();
        ShapeshifterLabel.setLayoutX(startLabelX);
        ShapeshifterLabel.setLayoutY(startLabelY+125);
        Boxs[17].setLayoutX(startLabelX+70);
        Boxs[17].setLayoutY(startLabelY+125);

        startLabelX+=125;

        Label SorcererLabel = new Label("Sorcerer:");
        Boxs[18] = new CheckBox();
        SorcererLabel.setLayoutX(startLabelX);
        SorcererLabel.setLayoutY(startLabelY);
        Boxs[18].setLayoutX(startLabelX+70);
        Boxs[18].setLayoutY(startLabelY);

        Label BotsLevel = new Label("Bots Level:");
        Boxs[19] = new CheckBox();
        BotsLevel.setLayoutX(startLabelX);
        BotsLevel.setLayoutY(startLabelY+25);
        Boxs[19].setLayoutX(startLabelX+70);
        Boxs[19].setLayoutY(startLabelY+25);


        center.getChildren().addAll(demonLabel,Boxs[0],
                RangerLabel,Boxs[1],DragonsLabel,Boxs[2],
                GlacialLabel,Boxs[3],ImperialLabel,Boxs[4],
                NobleLabel,Boxs[5],NinjaLabel,Boxs[6],
                PiratesLabel,Boxs[7],WildLabel,Boxs[8],
                VoidLabel,Boxs[9],YordleLabel,Boxs[10],
                AssassinLabel,Boxs[11],BladeMasterLabel,Boxs[12],
                BrawlerLabel,Boxs[13],ElementalistLabel,Boxs[14],
                GunslingerLabel,Boxs[15],KnightLabel,Boxs[16],
                ShapeshifterLabel,Boxs[17],SorcererLabel,Boxs[18],
                BotsLevel,Boxs[19]);



    }

    public void setBottom() {
        submitButton = new Button("Submit");
        submitButton.setLayoutX(20);
        submitButton.setLayoutY(-20);
        submitButton.setMinWidth(80);
        submitButton.setOnAction(e -> {
            window.setScene(scene2);
            window.setX(550);
            window.setY(150);
            Option.getObject().setNumberOfPlayers(Integer.parseInt(fieldNumOfPlayer.getText()));
            Option.getObject().setNumberOfBots(Integer.parseInt(fieldNumOfBots.getText()));
            Option.getObject().setCoinPerRound(Integer.parseInt(fieldNumOfCoinePerRound.getText()));
            Option.getObject().setNumberOfRound(Integer.parseInt(fieldNumOfRounds.getText()));
            Option.getObject().setNumberOfCopiesInStore(Integer.parseInt(fieldNumOfCopies.getText()));
            Option.getObject().setWidth(Integer.parseInt(fieldWidth.getText()));
            Option.getObject().setHigth(Integer.parseInt(fieldHeight.getText()));
            Option.getObject().setNumberOfChampionInTemp(Integer.parseInt(fieldNumInTemp.getText()));
            Option.getObject().setLimtOfChampionInArena(Integer.parseInt(fieldChampionInArena.getText()));
            Option.getObject().setLimtOfChampionInBench(Integer.parseInt(fieldChampionInBench.getText()));
            Option.getObject().setLimitOfBuyMovePerRound(Integer.parseInt(fieldNumOfBuyMove.getText()));
            Option.getObject().setLimtOfSwaps(Integer.parseInt(fieldNumOfSwap.getText()));
            for(int i =0 ;i<19;i++){
                if(Boxs[i].isSelected()){
                    Option.getObject().AddNewActiveClass(fun1(i));
                }
            }
            Option.getObject().setHardLevel(Boxs[19].isSelected());
        });
        backButton = new Button("Back");
        backButton.setOnAction(e -> {
            window.setScene(scene2);
            window.setX(550);
            window.setY(150);
        });
        backButton.setLayoutX(500);
        backButton.setLayoutY(-20);
        backButton.setMinWidth(80);

        bottom = new Pane();
        bottom.getChildren().addAll(submitButton, backButton);
    }
    private ChampionClass fun1(int s){
        switch(s){
            case 0:
                return ChampionClass.Demon;
            case 2:
                return ChampionClass.Dragons;
            case 3:
                return ChampionClass.Glacial;
            case 4:
                return ChampionClass.Imperial;
            case 5:
                return ChampionClass.Noble;
            case 6:
                return ChampionClass.Ninja;
            case 7:
                return ChampionClass.Pirate;
            case 8:
                return ChampionClass.Wild;
            case 9:
                return ChampionClass.Void;
            case 10:
                return ChampionClass.Yordle;
            case 11:
                return ChampionClass.Assassin;
            case 12:
                return ChampionClass.BladeMaster;
            case 13:
                return ChampionClass.Brawler;
            case 14:
                return ChampionClass.Elementalist;
            case 15:
                return ChampionClass.Gunslinger;
            case 16:
                return ChampionClass.Knight;
            case 1:
                return ChampionClass.Ranger;
            case 17:
                return ChampionClass.Shapeshifter;
            case 18:
                return ChampionClass.Sorcerer;
            default:
                return ChampionClass.NON;
        }
    }
}
