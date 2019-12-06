package com.company.game;

public  class Option {

    private final int coinePerRound;
    private final int numberOfRound;
    private final int numberOfBots;
    private final int numberOfPlayers;
    private final int numberOfCopiesInStore;
    private final int numberOfChampionInTemp;

    public Option(int coinePerRound, int numberOfRound, int numberOfBots, int numberOfPlayers, int numberOfCopiesInStore, int numberOfChampionInTemp) {
        this.coinePerRound = coinePerRound;
        this.numberOfRound = numberOfRound;
        this.numberOfBots = numberOfBots;
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfCopiesInStore = numberOfCopiesInStore;
        this.numberOfChampionInTemp = numberOfChampionInTemp;
    }

    public int getCoinePerRound() {
        return coinePerRound;
    }

    public int getNumberOfRound() {
        return numberOfRound;
    }

    public int getNumberOfBots() {
        return numberOfBots;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfCopiesInStore() {
        return numberOfCopiesInStore;
    }

    public int getNumberOfChampionInTemp() {
        return numberOfChampionInTemp;
    }
}
