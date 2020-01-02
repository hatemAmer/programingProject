package com.company.game;

import com.company.main.BotsGUI;
import com.company.main.ImageV;
import com.company.Player.AutoPlayer;
import com.company.Player.ConsolePlayer;
import com.company.Player.GUIPlayer;
import com.company.Player.Player;
import com.company.champion.Champion;
import com.company.main.Img;
import com.company.move.BasicAttackMove;
import com.company.move.MoveFactory;
import com.company.move.WalkMove;
import com.company.store.ChampionClassFilter;
import com.company.store.InGameStore;
import com.company.store.StoreFilter;
import com.company.round.ExcuteMove;
import com.company.round.Planning;
import com.company.round.Round;
import com.company.store.TemporalStoreFilter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> currentPlayer = new ArrayList<Player>();
    private int numOfBots;
    private int numOfPlayers;
    // private StoreFilter storeFilter = new StoreFilter();
    private Option option;
    private Arena arena = new Arena();
    private static Player victoryPlayer;
    Stage window;
    Scene scene;
    BotsGUI botsGUI;

    public class Controller {
        Player player;
        ArrayList<Round> rounds;
        String[] images = new String[55];
        VBox tiers, bottom;
        Pane bench, temporalStore;
        VBox next;
        Pane battleField;
        ArrayList<ImageV> imagesInArena;
        ArrayList<ImageV> imagesInBench;
        ArrayList<ImageV> imagesInTemporalStore;
        ArrayList<Champion> championsInMyVision;
        ArrayList<ImageV> imagesInMyVision;
        int posXToBench[], posXToTemp[];
        Label coinsLabel;
        Label PlayerNumber;
        int playersCounter = 0, roundCounter = 1;
        int numOfPlaningRound = 0;
        int numOfRound = 0;
        boolean end = false;
        int counter1 = 0, counter2 = 0;

        public Controller(ArrayList<Round> rounds) {
            this.player = currentPlayer.get(0);
            this.rounds = rounds;
            init();
        }

        public void setImages() {
            for (int i = 0; i < 48; i++)
                images[i] = new String();
            images[0] = "Photos\\Aatrox_Render.png";
            images[1] = "Photos\\Morgana.png";
            images[2] = "Photos\\Kindred.png";
            images[3] = "Photos\\Brand.png";
            images[4] = "Photos\\MissFortune.png";
            images[5] = "Photos\\Kennen.png";
            images[6] = "Photos\\Lucian.png";
            images[7] = "Photos\\Katarina.png";
            images[8] = "Photos\\Gangplank.png";
            images[9] = "Photos\\Azir.png";
            images[10] = "Photos\\ahri.png";
            images[11] = "Photos\\Zed.png";
            images[12] = "Photos\\Talon.png";
            images[13] = "Photos\\Ashe.png";
            images[14] = "Photos\\Pyke.png";
            images[15] = "Photos\\Graves.png";
            images[16] = "Photos\\Yasuo.png";
            images[17] = "Photos\\sejuani.png";
            images[18] = "Photos\\Varus.png";
            images[19] = "Photos\\Sol.png";
            images[20] = "Photos\\Shen.png";
            images[21] = "Photos\\Volibear.png";
            images[22] = "Photos\\Lissandra.png";
            images[23] = "Photos\\Kassadin.png";
            images[24] = "Photos\\Evelynn.png";
            images[25] = "Photos\\Vayne.png";
            images[26] = "Photos\\Kayle.png";
            images[27] = "Photos\\Mordekaiser.png";
            images[28] = "Photos\\Anivia.png";
            images[29] = "Photos\\Rengar.png";
            images[30] = "Photos\\Warweak.png";
            images[31] = "Photos\\gnar.png";
            images[32] = "Photos\\Akali.png";
            images[33] = "Photos\\Darius.png";
            images[34] = "Photos\\Chogath.png";
            images[35] = "Photos\\Leona.png";
            images[36] = "Photos\\Draven.png";
            images[37] = "Photos\\Khazix.png";
            images[38] = "Photos\\Fiora.png";
            images[39] = "Photos\\Tristana.png";
            images[40] = "Photos\\Nidale.png";
            images[41] = "Photos\\Garen.png";
            images[42] = "Photos\\shyvana.png";
            images[43] = "Photos\\Karthus.png";
            images[44] = "Photos\\Lulu.png";
            images[45] = "Photos\\Poppy.png";
            images[46] = "Photos\\Swain.png";
            images[47] = "Photos\\Veigar.png";
            images[48] = "Photos\\avian.png";

            images[49] = "Photos\\grass.png";
            images[50] = "Photos/7-2-water-png-clipart.png";
            images[51] = "Photos/hill-576592_960_720.png";
        }

        void init() {
            imagesInArena = new ArrayList<ImageV>();
            imagesInBench = new ArrayList<ImageV>();
            imagesInTemporalStore = new ArrayList<ImageV>();
            imagesInMyVision = new ArrayList<ImageV>();
            //championsInMyVision.clear();
            posXToBench = new int[9];
            posXToTemp = new int[9];
            for (int i = 0; i < 9; i++) {
                posXToBench[i] = 0;
                posXToTemp[i] = 0;
            }
            player.setNumSwaps(0);
            counter1 = 0;
            counter2 = 0;
        }

        public void setTiers() {
            tiers = new VBox();
            ((VBox) tiers).setAlignment(Pos.BASELINE_LEFT);
            tiers.getStyleClass().add("left");
            tiers.setMinSize(120, 440);
            tiers.setMaxWidth(120);
            //tiers.setMaxSize(120, 440);
            coinsLabel = new Label("My coins : " + player.getCoin() + "\n");
            PlayerNumber = new Label("Player Number: " + player.getMyNumber() + "\n");
            coinsLabel.setTextFill(Color.web("#ffffff", 0.8));
            PlayerNumber.setTextFill(Color.web("#ffffff", 0.8));
            tiers.getChildren().addAll(PlayerNumber, coinsLabel);

        }

        public void addToBench(Champion ch) throws FileNotFoundException {
            int j = player.getCurrentChampionInBench().indexOf(ch);
            Champion.ChampionAttributes CA = ch.new ChampionAttributes();
//            int x;
//            x = CA.getChampionNumber();
//            if (x > 1)
//                x = 0;
            imagesInBench.add(new ImageV(images[CA.getChampionNumber()], CA.getName().substring(0, 1) + CA.getName().substring(1, 2)
                    + " P" + CA.getPlayer() + " L" + CA.getLevel()));
            Integer c = 0;
            while (posXToBench[c] != 0)
                c++;
            imagesInBench.get(j).setPosition(c * 100 + 250, 5);

            imagesInBench.get(j).addItemToContextMenu("Swap to");
            imagesInBench.get(j).setContextMenu();

            imagesInBench.get(j).addItemToContextMenu("Sell");
            imagesInBench.get(j).setContextMenu();
            Integer finalC = c;
            imagesInBench.get(j).getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int j = player.getCurrentChampionInBench().indexOf(ch);
                    System.out.println(player.isValidSwap());
                    if (player.isValidSwap()) {
                        posXToBench[finalC] = 0;
                        player.setChampionInBench(-1);
                        player.setChampionInArena(+1);
                        player.setNumSwaps();
                        Label label1 = new Label("X position");
                        label1.setTextFill(Color.web("#ffffff", 0.8));
                        TextField field1 = new TextField();
                        field1.setPromptText("Only integer");
                        Label label2 = new Label("Y position");
                        label2.setTextFill(Color.web("#ffffff", 0.8));
                        TextField field2 = new TextField();
                        field2.setPromptText("Only integer");
                        Button button = new Button("Submit");
                        tiers.getChildren().addAll(label1, field1, label2, field2, button);
                        field1.requestFocus();
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event1) {
                                arena.addToList(ch);
                                player.getCurrentChampionInArena().add(ch);
                                player.getCurrentChampionInBench().remove(ch);
                                bench.getChildren().remove(imagesInBench.get(j).getvBox());
                                try {
                                    CA.setSquare(new Square(Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText())));
                                    addToBattleField(ch, Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText()));
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                imagesInBench.remove(imagesInBench.get(j));
                                tiers.getChildren().removeAll(label1, field1, label2, field2, button);
                            }
                        });
                    }
                }
            });
            imagesInBench.get(j).getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    player.setChampionInBench(-1);
                    player.addCoin(CA.getGoldCost());
                    coinsLabel.setText("My coins : " + player.getCoin() + "\n");
                    player.move = new MoveFactory();
                    player.move.MakeSellMove(ch);
                    //player.getCurrentChampionsInTemporalStore().add(player.getCurrentChampionInBench().get(i));
                    player.getCurrentChampionInBench().remove(ch);
                    posXToBench[finalC] = 0;
                    bench.getChildren().remove(imagesInBench.get(j).getvBox());
//                    try {
//                        addToTemporalStore(player.getCurrentChampionsInTemporalStore().size() - 1);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    imagesInBench.remove(imagesInBench.get(j));
                }
            });

            final Label[] infoLabel = new Label[1];
            EventHandler<MouseEvent> eventInfo = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        infoLabel[0] = new Label(player.displayChampionInfo(ch));
                        Pane pane = new Pane();
                        infoLabel[0].setTextFill(Color.web("#ffffff", 0.8));
                        Button button = new Button("Close");
                        button.setLayoutY(infoLabel[0].getLayoutY() + 120);
                        button.setOnAction(e -> tiers.getChildren().removeAll(pane));
                        pane.getChildren().addAll(infoLabel[0], button);
                        tiers.getChildren().addAll(pane);
                    }
                }
            };
            imagesInBench.get(j).getvBox().addEventHandler(MouseEvent.MOUSE_CLICKED, eventInfo);

            bench.getChildren().add(imagesInBench.get(j).getvBox());
            posXToBench[c] = 100;
        }

        public void setBench() throws FileNotFoundException {
            bench = new Pane();
            bench.getStyleClass().add("bench");
            bench.setMinHeight(80);
            bench.setMaxHeight(80);
            Label label = new Label("Bench: ");
            label.setTextFill(Color.web("#ffffff", 0.8));
            label.getStyleClass().add("nameLabel");
            label.setLayoutX(2);
            label.setLayoutY(10);
            bench.getChildren().add(label);
            for (Champion ch : player.getCurrentChampionInBench()) {
                addToBench(ch);
            }

        }

        public void addToTemporalStore(Champion ch) throws FileNotFoundException {
            int j = player.getCurrentChampionsInTemporalStore().indexOf(ch);
            Champion.ChampionAttributes CA = ch.new ChampionAttributes();
//            int x;
//            x = CA.getChampionNumber();
//            if (x > 1)
//                x = 0;
            imagesInTemporalStore.add(new ImageV(images[CA.getChampionNumber()], CA.getName().substring(0, 1) + CA.getName().substring(1, 2)
                    + " L" + CA.getLevel()));
            Integer c = 0;
            while (posXToTemp[c] != 0)
                c++;
            imagesInTemporalStore.get(j).setPosition(c * 100 + 250, 5);

            imagesInTemporalStore.get(j).addItemToContextMenu("Buy");
            imagesInTemporalStore.get(j).setContextMenu();

            Integer finalC = c;
            imagesInTemporalStore.get(j).getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int j = player.getCurrentChampionsInTemporalStore().indexOf(ch);
                    if (player.checkCoins(CA.getGoldCost()) && player.isValidBuyMove()) {
                        player.setChampionInBench(+1);
                        player.addCoin(-1 * CA.getGoldCost());
                        coinsLabel.setText("My coins : " + player.getCoin() + "\n");
                        player.move = new MoveFactory();
                        player.move.MakeBuyMove(ch, player.getMyNumber());
                        player.getCurrentChampionInBench().add(ch);
                        player.getCurrentChampionsInTemporalStore().remove(ch);
                        temporalStore.getChildren().remove(imagesInTemporalStore.get(j).getvBox());
                        posXToTemp[finalC] = 0;
                        player.cheakLevel(ch, player.getCurrentChampionInArena());
                        try {
                            addToBench(ch);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        imagesInTemporalStore.remove(imagesInTemporalStore.get(j));
                    }
                }
            });

            final Label[] infoLabel = new Label[1];
            EventHandler<MouseEvent> eventInfo = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        infoLabel[0] = new Label(player.displayChampionInfo(ch));
                        infoLabel[0].setTextFill(Color.web("#ffffff", 0.8));
                        VBox vBox = new VBox();
                        Pane pane = new Pane();
                        Button button = new Button("Close");
                        button.setLayoutY(infoLabel[0].getLayoutY() + 120);
                        button.setOnAction(e -> tiers.getChildren().removeAll(vBox));
                        pane.getChildren().addAll(infoLabel[0], button);
                        vBox.getChildren().addAll(pane);
                        tiers.getChildren().addAll(vBox);
                    }
                }
            };
            imagesInTemporalStore.get(j).getvBox().addEventHandler(MouseEvent.MOUSE_CLICKED, eventInfo);

            temporalStore.getChildren().add(imagesInTemporalStore.get(j).getvBox());
            posXToTemp[c] = 100;
        }

        public void setTemporalStore() throws FileNotFoundException {
            temporalStore = new Pane();
            temporalStore.getStyleClass().add("temp");
            temporalStore.setMinHeight(80);
            temporalStore.setMinWidth(650);
            temporalStore.setMaxHeight(80);
            temporalStore.setMaxWidth(650);
            Label label = new Label("Temporal store:");
            label.setTextFill(Color.web("#ffffff", 0.8));
            label.getStyleClass().add("nameLabel");
            label.setLayoutX(2);
            label.setLayoutY(10);
            temporalStore.getChildren().add(label);
            if (player.getCurrentChampionsInTemporalStore() != null)
                for (Champion ch : player.getCurrentChampionsInTemporalStore()) {
                    //Integer i = player.getCurrentChampionsInTemporalStore().indexOf(ch);
                    addToTemporalStore(ch);
                }

        }

        public void setBottom() throws FileNotFoundException {
            bottom = new VBox();

            setBench();
            setTemporalStore();
            setNext();

            HBox hBox = new HBox();
            hBox.getChildren().addAll(temporalStore);

            BorderPane borderPane = new BorderPane();
            borderPane.setLeft(hBox);
            borderPane.setRight(next);

            bottom.getChildren().addAll(bench, borderPane);
            bottom.getStyleClass().add("bottomContianer");
        }

        public void attackEvent(Champion ch) {
            int j = championsInMyVision.indexOf(ch);
            Champion.ChampionAttributes CA1 = ch.new ChampionAttributes();
//            int x;
//            x = CA1.getChampionNumber();
//            if (x > 1)
//                x = 0;
            try {
                imagesInMyVision.add(new ImageV(images[CA1.getChampionNumber()], CA1.getName().substring(0, 1) + CA1.getName().substring(1, 2)
                        + " P" + CA1.getPlayer() + " L" + CA1.getLevel()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imagesInMyVision.get(j).setPosition(CA1.getSquare().getX() * 10, CA1.getSquare().getY() * 10);

            final Label[] infoLabel = new Label[1];
            EventHandler<MouseEvent> eventInfo = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    int j = championsInMyVision.indexOf(ch);
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {

                        infoLabel[0] = new Label("Health : " + CA1.getHealth() + "\n"
                                + "Mana : " + CA1.getManaStart() + "\n"
                                + "id : " + j + "\n");
                        infoLabel[0].setTextFill(Color.web("#ffffff", 0.8));
                        Pane pane = new Pane();
                        Button button = new Button("Close");
                        button.setLayoutY(infoLabel[0].getLayoutY() + 50);
                        button.setOnAction(e -> tiers.getChildren().remove(pane));
                        pane.getChildren().addAll(infoLabel[0], button);
                        tiers.getChildren().addAll(pane);
                    }
                }
            };
            imagesInMyVision.get(j).getvBox().addEventHandler(MouseEvent.MOUSE_CLICKED, eventInfo);

            battleField.getChildren().add(imagesInMyVision.get(j).getvBox());

        }

        public void addToBattleField(Champion ch, int posX, int posY) throws FileNotFoundException {
            int j = player.getCurrentChampionInArena().indexOf(ch);
            Champion.ChampionAttributes CA = ch.new ChampionAttributes();
            //            int x;
            //            x = CA.getChampionNumber();
            //            if (x > 1)
            //                x = 0;
            imagesInArena.add(new ImageV(images[CA.getChampionNumber()], CA.getName().substring(0, 1) + CA.getName().substring(1, 2)
                    + " P" + CA.getPlayer() + " L" + CA.getLevel()));
            imagesInArena.get(j).setPosition(posX * 10, posY * 10);

            imagesInArena.get(j).addItemToContextMenu("Attack");
            imagesInArena.get(j).addItemToContextMenu("Move");
            imagesInArena.get(j).addItemToContextMenu("Use ability");
            imagesInArena.get(j).addItemToContextMenu("Sell");
            imagesInArena.get(j).setContextMenu();
            imagesInArena.get(j).getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int j = player.getCurrentChampionInArena().indexOf(ch);
                    if (numOfRound > numOfPlaningRound) {
                        championsInMyVision = player.getVision(ch, arena.getChampionsInArena());
                        imagesInMyVision = new ArrayList<ImageV>();
                        for (Champion champion : championsInMyVision) {
                            attackEvent(champion);
                        }
                        if (championsInMyVision.size() != 0) {
                            Label label1 = new Label("id champion");
                            label1.setTextFill(Color.web("#ffffff", 0.8));
                            TextField field1 = new TextField();
                            field1.setPromptText("Only id");
                            field1.requestFocus();
                            Button button = new Button("Submit");
                            Button cancelButton = new Button("Cancel");
                            cancelButton.setOnAction(e -> {
                                tiers.getChildren().removeAll(label1, field1, button, cancelButton);
                                for (int i = 0; i < imagesInMyVision.size(); i++)
                                    battleField.getChildren().removeAll(imagesInMyVision.get(i).getvBox());
                            });
                            tiers.getChildren().addAll(label1, field1, button, cancelButton);
                            field1.requestFocus();
                            button.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    ch.new ChampionAttributes()
                                            .setMoves(new BasicAttackMove(ch
                                                    , championsInMyVision.get(Integer.parseInt(field1.getText()))));
                                    tiers.getChildren().removeAll(label1, field1, button, cancelButton);
                                }
                            });
                        }
                    }
                }
            });
            imagesInArena.get(j).getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (numOfRound > numOfPlaningRound) {
                        Label label1 = new Label("X position");
                        label1.setTextFill(Color.web("#ffffff", 0.8));
                        TextField field1 = new TextField();
                        field1.setPromptText("Only integer");
                        Label label2 = new Label("Y position");
                        label2.setTextFill(Color.web("#ffffff", 0.8));
                        TextField field2 = new TextField();
                        field2.setPromptText("Only integer");
                        Button button = new Button("Submit");
                        Button cancelButton = new Button("Cancel");
                        cancelButton.setOnAction(e -> tiers.getChildren().removeAll(label1, field1, label2, field2, button, cancelButton));
                        tiers.getChildren().addAll(label1, field1, label2, field2, button, cancelButton);
                        field1.requestFocus();
                        button.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event1) {
                                //imagesInArena.get(i).setPosition(Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText()));
                                CA.setMoves(new WalkMove(ch, new Square(
                                        Integer.parseInt(field1.getText()), Integer.parseInt(field2.getText()))));
                                tiers.getChildren().removeAll(label1, field1, label2, field2, button, cancelButton);
                            }
                        });
                    }
                }
            });
            imagesInArena.get(j).getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Champion.ChampionAttributes CA = ch.new ChampionAttributes();
                    if (numOfRound > numOfPlaningRound && CA.getManaStart() >= CA.getManaCost()) {
                        CA.setManaStart(CA.getManaStart() - (int) CA.getManaCost());
                        CA.setMoves(new MoveFactory().MakeAbilityMove(ch, arena.getChampionsInArena()));
                    }
                }
            });
            imagesInArena.get(j).getItems().get(3).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int j = player.getCurrentChampionInArena().indexOf(ch);
                    player.setChampionInArena(-1);
                    arena.deleteFromList(ch);
                    player.addCoin(CA.getGoldCost());
                    coinsLabel.setText("My coins : " + player.getCoin() + "\n");
                    player.move = new MoveFactory();
                    player.move.MakeSellMove(ch);
                    //player.getCurrentChampionsInTemporalStore().add(player.getCurrentChampionInArena().get(i));
                    player.getCurrentChampionInArena().remove(ch);
                    battleField.getChildren().remove(imagesInArena.get(j).getvBox());
//                    try {
//                        addToTemporalStore(player.getCurrentChampionsInTemporalStore().size() - 1);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    imagesInArena.remove(imagesInArena.get(j));
                }
            });

            final Label[] infoLabel = new Label[1];
            EventHandler<MouseEvent> eventInfo = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                        infoLabel[0] = new Label(player.displayChampionInfo(ch));
                        Pane pane = new Pane();
                        infoLabel[0].setTextFill(Color.web("#ffffff", 0.8));
                        Button button = new Button("Close");
                        button.setLayoutY(infoLabel[0].getLayoutY() + 120);
                        button.setOnAction(e -> tiers.getChildren().removeAll(pane));
                        pane.getChildren().addAll(infoLabel[0], button);
                        tiers.getChildren().addAll(pane);
                    }
                }
            };
            imagesInArena.get(j).getvBox().addEventHandler(MouseEvent.MOUSE_CLICKED, eventInfo);

            battleField.getChildren().add(imagesInArena.get(j).getvBox());
        }

        public void setBattleField() throws FileNotFoundException {
            battleField = new Pane();
            battleField.getStyleClass().add("battleField");

            for (Champion ch : player.getCurrentChampionInArena()) {
                Champion.ChampionAttributes CA = ch.new ChampionAttributes();
                addToBattleField(ch, CA.getSquare().getX(), CA.getSquare().getY());
            }

        }

        public void setBotsActions() {
            for (int i = playersCounter + 1; i < numOfPlayers + numOfBots; i++) {
                try {
                    ArrayList<Champion> temp = (new TemporalStoreFilter
                            (new ChampionClassFilter(
                                    new StoreFilter()))).GetChampionList();
                    currentPlayer.get(i).addCoin(Option.getObject().getCoinePerRound());
                    currentPlayer.get(i).start(arena.getChampionsInArena(), temp);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }

        public void cheak() {
            int counter = 0;
            for (int j = 0; j < Game.this.currentPlayer.size(); j++) {
                if (Game.this.currentPlayer.get(j).getChampionInArena() == 0) {
                    Game.this.currentPlayer.get(j).setRunning();
                }
            }

            for (int j = 0; j < Game.this.currentPlayer.size(); j++) {
                if (Game.this.currentPlayer.get(j).isRunning()) {
                    counter++;
                    victoryPlayer = Game.this.currentPlayer.get(j);
                }
            }
            int counter1 = 0;
            for (int j = 0; j < numOfPlayers; j++) {
                if (Game.this.currentPlayer.get(j).isRunning()) {
                    counter1++;
                }
            }
            if (counter1 < numOfPlayers)
                numOfPlayers = counter1;
            boolean noOneWin = false;
            if (counter == 0) {
                Label winLabel = new Label("|      No one win     |");
                winLabel.setTextFill(Color.web("white"));
                //nextButton.setVisible(false);
                next.getChildren().add(winLabel);
                //numOfPlayers--;
                end = true;
                noOneWin = true;
            }
            if (counter == 1) {
                Label winLabel = new Label("|      Player " + victoryPlayer.getMyNumber() + " victory     |");
                winLabel.setTextFill(Color.web("white"));
                //nextButton.setVisible(false);
                next.getChildren().add(winLabel);
                //numOfPlayers--;
                end = true;
            }
            if (counter1 == 0 && !noOneWin) {
                Label winLabel = new Label("|      you has been defeated     |");

                winLabel.setTextFill(Color.web("white"));//nextButton.setVisible(false);
                next.getChildren().add(winLabel);
                //numOfPlayers--;
                end = true;
            }
        }

        public void createPlayerPlanningRound() {
            currentPlayer.get(playersCounter).addCoin(Option.getObject().getCoinePerRound());
            try {
                currentPlayer.get(playersCounter).setCurrentChampionsInTemporalStore((new TemporalStoreFilter
                        (new ChampionClassFilter(
                                new StoreFilter()))).GetChampionList());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                if (currentPlayer.get(playersCounter) instanceof GUIPlayer) {
                    init();
                    this.player = currentPlayer.get(playersCounter);
                    start();
                } else
                    currentPlayer.get(playersCounter).start(arena.getChampionsInArena(), (new TemporalStoreFilter
                            (new ChampionClassFilter(
                                    new StoreFilter()))).GetChampionList());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        public void save() {
            File file = new File("player1.txt");
            Player p = player;
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                writer.close();

                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream o = new ObjectOutputStream(f);

                // Write objects to file
                o.writeObject(p);
                o.close();
                f.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            String autoPlayerfile = "autoPlayer";
            int j = 1;
            for (int i = playersCounter + 1; i < numOfPlayers + numOfBots; i++) {
                file = new File(autoPlayerfile + j + ".txt");
                j++;
                try {
                    PrintWriter writer = new PrintWriter(file);
                    writer.print("");
                    writer.close();

                    FileOutputStream f = new FileOutputStream(file);
                    ObjectOutputStream o = new ObjectOutputStream(f);

                    p = currentPlayer.get(i);
                    // Write objects to file
                    o.writeObject(p);

                    o.close();
                    f.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            file = new File("store.txt");
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.print("");
                writer.close();

                FileOutputStream f = new FileOutputStream(file);
                ObjectOutputStream o = new ObjectOutputStream(f);
                // Write objects to file
                o.writeObject(InGameStore.refToStore.store);
                o.close();
                f.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        public void setNext() {
            next = new VBox();
            next.getStyleClass().add("next");
            next.setMinWidth(350);

            Button nextButton = new Button("Next");
            nextButton.getStyleClass().add("nextButton");
            nextButton.setMinWidth(120);
            nextButton.setMinHeight(30);
            nextButton.setOnAction(e -> {
                if (playersCounter >= numOfPlayers - 1) {
                    currentPlayer.get(playersCounter).setNumSwaps(0);
                    setBotsActions();
                    if (numOfRound > numOfPlaningRound) {
                        //cheak win or lose
                        cheak();

                        //do planning and excuting
                        try {
                            rounds.get(roundCounter - 1).startActionGUI(Game.this.currentPlayer);
                            rounds.get(roundCounter).startAction(Game.this.currentPlayer);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }

                        roundCounter += 2;
                    }

                    playersCounter = 0;
                    numOfRound++;

                } else
                    playersCounter++;

                //create player GUI to next step
                if (currentPlayer.get(playersCounter).isRunning() && !end) {
                    createPlayerPlanningRound();
                }

                //end of game
                if (end) {
                    nextButton.setVisible(false);
                }

                save();

            });

            next.getChildren().addAll(nextButton);
            next.setAlignment(Pos.BOTTOM_RIGHT);
            next.setPadding(new Insets(10, 20, 10, 20));
        }

        public void start() throws Exception {
            window.setTitle("Tactical Chaos TM");
            BorderPane layout = new BorderPane();
            scene = new Scene(layout, 1200, 650);
            layout.getStyleClass().add("layout");
            setTiers();
            setBattleField();
            setBottom();

            Img grass = new Img(images[49]);
            battleField.getChildren().addAll(grass.getImage());
            Img water = new Img(images[50]);
            water.setImagePos(50, 50);
            battleField.getChildren().addAll(water.getImage());
            Img teran = new Img(images[51]);
            teran.setImagePos(100, 100);
            battleField.getChildren().addAll(teran.getImage());

            // BorderPane layout = new BorderPane();
            layout.setLeft(tiers);
            layout.setCenter(battleField);
            layout.setBottom(bottom);

            //  scene = new Scene(layout, 1000, 600);

            scene.getStylesheets().add("cssFiles/styles.css");
            window.setX(80);
            window.setY(35);
            window.setScene(scene);
            window.show();

        }

    }

    public Game() {
        int count = 1;
        for (int i = 0; i < Option.getObject().getNumberOfBots(); i++) {
            Player p = new AutoPlayer();
            p.setMyNumber(count++);
            currentPlayer.add(p);
        }


        for (int i = 0; i < Option.getObject().getNumberOfPlayers(); i++) {
            Player p = new ConsolePlayer();
            p.setMyNumber(count++);
            currentPlayer.add(p);
        }
    }

    public Game(int bot, int Players, Stage window, Scene scene) throws Exception {
        /*
         * to init the number of bots numbers and players numbers
         * and make sure the game will consist of 8 players or less
         * */
        this.window = window;
        this.scene = scene;

        int count = 1;
        if (bot <= 8)
            this.numOfBots = bot;
        else
            this.numOfBots = 8;

        if (Players + this.numOfBots > 8)
            this.numOfPlayers = 8 - numOfBots;
        else
            this.numOfPlayers = Players;

        for (int i = 0; i < numOfPlayers; i++) {
            File file = new File("player1.txt");
            Player p = null;
            if (file.length() == 0) {
                try {
                    p = new GUIPlayer();
                    p.setMyNumber(count++);

                    FileOutputStream f = new FileOutputStream(file);
                    ObjectOutputStream o = new ObjectOutputStream(f);

                    // Write objects to file
                    o.writeObject(p);
                    o.close();
                    f.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                p = (Player) oi.readObject();
                oi.close();
                fi.close();
            }
            currentPlayer.add(p);

        }
        String autoPlayerfile = "autoPlayer";
        int j = 1;
        for (int i = 0; i < numOfBots; i++) {
            File file = new File(autoPlayerfile + j + ".txt");
            j++;
            Player p = null;
            if (file.length() == 0) {
                try {
                    p = new AutoPlayer();
                    p.setMyNumber(count++);

                    FileOutputStream f = new FileOutputStream(file);
                    ObjectOutputStream o = new ObjectOutputStream(f);

                    // Write objects to file
                    o.writeObject(p);
                    o.close();
                    f.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                p = (Player) oi.readObject();
                oi.close();
                fi.close();
            }
            currentPlayer.add(p);
        }

    }

    public static void setVictoryPlayer(Player victoryPlayer) {
        Game.victoryPlayer = victoryPlayer;
    }

    public abstract class RoundManager {
        protected ArrayList<Round> rounds = new ArrayList<Round>();
        protected int numOfRounds;

        public RoundManager() {
            this.numOfRounds = 10000;
            generateList();
        }

        public RoundManager(int numOfRound) {
            this.numOfRounds = numOfRound;
            generateList();
        }

        public abstract void generateList();

        public abstract void RunTurn() throws Exception;

        public abstract void RunTurnGUI() throws Exception;
    }

    public class TacticalChaosTM extends RoundManager {
        public TacticalChaosTM(int numOfRound) {
            super(numOfRound);
        }

        public TacticalChaosTM() {
            super();
        }

        @Override
        public void generateList() {
            for (int i = 0; i < Option.getObject().getNumberOfRound(); i++) {
                if (i % 2 == 0)
                    rounds.add(new Planning(Game.this.arena.getChampionsInArena()));
                else
                    rounds.add(new ExcuteMove(Game.this.arena.getChampionsInArena()));
            }
        }

        @Override
        public void RunTurn() throws Exception {
            for (int i = 0; i < Option.getObject().getNumberOfRound(); i++) {
                int counter = 0;
                //System.out.print("////"+i+"////");

                rounds.get(i).startAction(Game.this.currentPlayer);
                //BotsGUI.bots.setBattleField(arena.getChampionsInArena());
                //Thread.sleep(100);

                for (int j = 0; j < Game.this.currentPlayer.size(); j++) {
                    if (Game.this.currentPlayer.get(j).getChampionInArena() == 0)
                        Game.this.currentPlayer.get(j).setRunning();
                }

                for (int j = 0; j < Game.this.currentPlayer.size(); j++) {
                    if (Game.this.currentPlayer.get(j).isRunning()) {
                        counter++;
                        victoryPlayer = Game.this.currentPlayer.get(j);
                    }
                }
                if (counter == 1) {
                    System.out.println();
                    System.out.println("|--------------------------|");
                    System.out.println("|      Player " + victoryPlayer.getMyNumber() + " victory     |");
                    System.out.println("|--------------------------|");
                    for (int j = 0; j < victoryPlayer.getCurrentChampionInArena().size(); j++)
                        System.out.println(victoryPlayer.getCurrentChampionInArena().get(j));
                    break;
                }
            }
        }

        @Override
        public void RunTurnGUI() throws Exception {
            //if ((new TemporalStoreFilter(new ChampionClassFilter(new StoreFilter()))).GetChampionList() != null) {
                currentPlayer.get(0).addCoin(Option.getObject().getCoinePerRound());
                currentPlayer.get(0).setCurrentChampionsInTemporalStore((new TemporalStoreFilter
                        (new ChampionClassFilter(
                                new StoreFilter()))).GetChampionList());

                Controller controller = new Controller(rounds);
                controller.setImages();
                controller.start();
            //}
        }
    }

}
