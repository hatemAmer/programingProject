package com.company.round;

import com.company.Player.Player;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Round {
    public abstract void startAction(ArrayList<Player> pl) throws Exception;

    public void startActionGUI(ArrayList<Player> currentPlayer) throws Exception {}
}
