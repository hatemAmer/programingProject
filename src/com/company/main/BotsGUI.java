package com.company.main;

import com.company.Player.Player;
import com.company.champion.Champion;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class BotsGUI {
    public static BotsGUI bots;
    Stage window;
    Scene scene1;
    Pane pane;
    ArrayList<ImageV> imageVS = new ArrayList<ImageV>();
    ArrayList<Champion> champions = new ArrayList<Champion>();
    Player player;
    String[] images = new String[50];

    public BotsGUI(Stage window, Scene scene1) {
        this.window = window;
        this.scene1 = scene1;
        setImgs();
        setScene4();
    }

    public void setImgs() {
        for (int i = 0; i < 49; i++)
            images[i] = new String();
        images[0] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Aatrox_Render.png";
        images[1] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Morgana.png";
        images[2] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Kindred.png";
        images[3] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Brand.png";
        images[4] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\MissFortune.png";
        images[5] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Kennen.png";
        images[6] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Lucian.png";
        images[7] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Katarina.png";
        images[8] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Gangplank.png";
        images[9] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Azir.png";
        images[10] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\ahri.png";
        images[11] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Zed.png";
        images[12] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Talon.png";
        images[13] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Ashe.png";
        images[14] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Pyke.png";
        images[15] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Graves.png";
        images[16] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Yasuo.png";
        images[17] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\sejuani.png";
        images[18] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Varus.png";
        images[19] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Sol.png";
        images[20] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Shen.png";
        images[21] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Volibear.png";
        images[22] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Lissandra.png";
        images[23] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Kassadin.png";
        images[24] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Evelynn.png";
        images[25] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Vayne.png";
        images[26] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Kayle.png";
        images[27] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Mordekaiser.png";
        images[28] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Anivia.png";
        images[29] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Rengar.png";
        images[30] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Warweak.png";
        images[31] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\gnar.png";
        images[32] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Akali.png";
        images[33] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Darius.png";
        images[34] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Chogath.png";
        images[35] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Leona.png";
        images[36] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Draven.png";
        images[37] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Khazix.png";
        images[38] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Fiora.png";
        images[39] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Tristana.png";
        images[40] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Nidale.png";
        images[41] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Garen.png";
        images[42] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\shyvana.png";
        images[43] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Karthus.png";
        images[44] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Lulu.png";
        images[45] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Poppy.png";
        images[46] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Swain.png";
        images[47] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\Veigar.png";
        images[48] = "D:\\IT_engnering\\java_project\\finalTestOfTC\\src\\Photos\\avian.png";
    }

    public void setScene4() {
        pane = new Pane();
        pane.getStyleClass().add("battleField");

        scene1 = new Scene(pane, 1100, 600);
        scene1.getStylesheets().add("cssFiles/styles.css");
        window.setTitle("Watch");
        window.setScene(scene1);
        window.setX(100);
        window.setY(50);
        window.show();
    }

    public void addToBattleField(Champion ch, int posX, int posY) throws FileNotFoundException {
        int j = champions.indexOf(ch);
        if(j == -1)return;
        Champion.ChampionAttributes CA = ch.new ChampionAttributes();
        int x;
        x = CA.getChampionNumber();
        if (x <0)
            x = 0;
        imageVS.add(new ImageV(images[x], CA.getName().substring(0, 1) + CA.getName().substring(1, 2)
                + " P" + CA.getPlayer() + " L" + CA.getLevel()));
        imageVS.get(j).setPosition(posX * 10, posY * 10);

        pane.getChildren().add(imageVS.get(j).getvBox());
    }

    public void setBattleField(ArrayList<Champion> arena) throws FileNotFoundException, InterruptedException {
        pane.getChildren().clear();

        //champions = player.getCurrentChampionInArena();
        champions = arena;
        imageVS = new ArrayList<ImageV>();

        for (Champion ch : arena) {
            Champion.ChampionAttributes CA = ch.new ChampionAttributes();
            addToBattleField(ch, CA.getSquare().getX(), CA.getSquare().getY());
        }
        //Thread.sleep(10000);
    }


}
