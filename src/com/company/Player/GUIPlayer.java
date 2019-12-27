package com.company.Player;

import com.company.champion.Champion;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;


public class GUIPlayer extends Player implements Serializable {


    public GUIPlayer() {

    }

    public void start(ArrayList<Champion> arena, ArrayList<Champion> temp) throws Exception {
        this.currentChampionsInTemporalStore = temp;
    }


    @Override
    public void buildTempStore(ArrayList<Champion> ch) throws FileNotFoundException {
        this.currentChampionsInTemporalStore = ch;
    }

}
