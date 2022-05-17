package com.examples;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends AbstractPlayer{

    private String dealerName;

    public void setCards (List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards ;

    public String getDealerName ( ) {
        return dealerName;
    }

    public void setDealerName (String dealerName) {
        this.dealerName = dealerName;
    }

    public List<Card> getCards ( ) {
        return cards;
    }

    public Dealer (){
        this("Dealer");
    }

    public Dealer(final String dealerName) {
        super(dealerName);
        this.cards = new ArrayList<>();
    }

    @Override
    public void play (List<Card> cards, int cardsToDraw) {
        if (cards.isEmpty()) throw new IllegalArgumentException("No more card to draw.");
        if (cardsToDraw < 0) throw  new IllegalArgumentException("No of cards to draw cannot be negative.");
        CardPlayDetermination cardPlayDetermination = new CardPlayDetermination();
        List<Card> list =  cards.subList(0,cardsToDraw);
        this.getCards().addAll(list);
        cards.removeAll(list);
        this.showCards();
    }

    @Override
    public void showCards ( ) {
        System.out.println("Showing cards of "+this.getPlayerName());
        System.out.println();
        CardDecorator cardDecorator = new CardDecorator();
        cardDecorator.cards(cards.size(), cards);
    }
}
