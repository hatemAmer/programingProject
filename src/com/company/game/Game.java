package com.company.game;

import com.company.Player.AutoPlayer;
import com.company.Player.GUIPlayer;
import com.company.Player.Player;
import com.company.champion.Champion;
import com.company.round.ExcuteMove;
import com.company.round.Planning;
import com.company.round.Round;
import com.company.store.StoreFilter;
import com.company.store.TemporalStoreFilter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> currentPlayer = new ArrayList<Player>();
    private int numOfBots;
    private int numOfPlayers;
    private StoreFilter storeFilter = new StoreFilter();

    private Game() {
    }

    private Game(int bot, int Players) {
        /*
         * to init the number of bots numbers and players numbers
         * and make sure the game will consist of 8 players or less
         * */
        int count = 1;
        if (bot <= 8)
            this.numOfBots = bot;
        else
            this.numOfBots = 8;

        if (Players + this.numOfBots > 8)
            this.numOfPlayers = 8 - numOfBots;
        else
            this.numOfPlayers = Players;

        /*
         * create the player list
         * */

        for (int i = 0; i < numOfBots; i++) {
            Player p = new AutoPlayer();
            p.setMyNumber(count++);
            currentPlayer.add(p);
        }


        for (int i = 0; i < numOfPlayers; i++) {
            Player p = new GUIPlayer();
            p.setMyNumber(count++);
            currentPlayer.add(p);
        }
    }

    public abstract class RoundManager {
        protected ArrayList<Round> rounds = new ArrayList<Round>();
        protected int numOfRounds;

        public RoundManager() {
            this.numOfRounds = 10000;
            generateList();
        }

        public RoundManager(int numOfRound) {
            if (numOfRound > 10000)
                this.numOfRounds = 10000;
            else
                this.numOfRounds = numOfRound;

            if (numOfRound < 10)
                this.numOfRounds = 21;
            generateList();
        }

        public abstract void generateList();

        public abstract void RunTurn() throws FileNotFoundException;
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
            for (int i = 0; i < numOfRounds; i++) {
                if (i < 9 || i % 2 == 1)
                    rounds.add(new Planning());
                else
                    rounds.add(new ExcuteMove());
            }
        }

        @Override
        public void RunTurn() throws FileNotFoundException {
            for (int i = 0; i < this.numOfRounds; i++) {
                Round temp = rounds.get(i);
                //if(temp instanceof Planning)
                currentPlayer.get(0).buildTempStore((new TemporalStoreFilter(5, Game.this.storeFilter)).GetChampionList());
                currentPlayer.get(0).addCoin(2);
                //currentPlayer.get(0).setPlan();
            }
        }
    }

}
