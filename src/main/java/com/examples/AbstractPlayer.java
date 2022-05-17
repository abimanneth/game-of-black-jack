package com.examples;

import java.util.List;

public abstract class AbstractPlayer {
    private String playerName;

    public AbstractPlayer(){
        super();
    }
    public AbstractPlayer(final String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName ( ) {
        return playerName;
    }

    public void setPlayerName (final String playerName) {
        this.playerName = playerName;
    }

    public abstract void play (final List<Card> cards, final int cardsToDraw );

    public abstract void showCards();
}
