package com.examples;

import java.util.ArrayList;
import java.util.List;

public final class Player extends AbstractPlayer {
    private String playerName;
    private double betAmount;

    public Player setCardList (List<Card> cardList) {
        this.cardList = cardList;
        return this;
    }

    private List<Card> cardList;

    public Player(){
        this("Player");
    }
    public Player(final String playerName) {
        super(playerName);
        this.playerName = playerName;
        this.cardList = new ArrayList<>();
    }

    public String getPlayerName ( ) {
        return playerName;
    }

    public void setPlayerName (String playerName) {
        this.playerName = playerName;
    }

    public double getBetAmount ( ) {
        return betAmount;
    }

    public void setBetAmount (double betAmount) {
        this.betAmount = betAmount;
    }



    public List<Card> getCardList ( ) {
        return cardList;
    }


    @Override
    public void play (final List<Card> shuffledCards,final int cardsToDraw) {
        if (shuffledCards.isEmpty()) throw new IllegalArgumentException("No more card to draw.");
        if (cardsToDraw < 0) throw  new IllegalArgumentException("No of cards to draw cannot be negative.");
        CardPlayDetermination cardPlayDetermination = new CardPlayDetermination();
        List<Card> list =  shuffledCards.subList(0,cardsToDraw);
        this.getCardList().addAll(list);
        shuffledCards.removeAll(list);
        this.showCards();
    }

    @Override
    public void showCards ( ) {
        System.out.println("Showing cards of "+this.getPlayerName());
        System.out.println();
        CardDecorator cardDecorator = new CardDecorator();
        cardDecorator.cards(cardList.size(), cardList);
    }
}
