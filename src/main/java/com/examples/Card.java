package com.examples;

import java.util.StringJoiner;

public final class Card {
    private Rank cardRank;
    private Color cardColor;
    private Suit  cardSuit;

    private Card(){
        super();
    }

    public Card(Rank cardRank, Color cardColor, Suit cardSuit) {
        this.cardRank = cardRank;
        this.cardColor = cardColor;
        this.cardSuit  = cardSuit;
    }

    public Rank getCardRank ( ) {
        return cardRank;
    }

    public Card setCardRank (Rank cardRank) {
        this.cardRank = cardRank;
        return this;
    }

    public Color getCardColor ( ) {
        return cardColor;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (cardRank != card.cardRank) return false;
        if (cardColor != card.cardColor) return false;
        return cardSuit == card.cardSuit;
    }

    @Override
    public int hashCode ( ) {
        int result = cardRank != null ? cardRank.hashCode() : 0;
        result = 31 * result + (cardColor != null ? cardColor.hashCode() : 0);
        result = 31 * result + (cardSuit != null ? cardSuit.hashCode() : 0);
        return result;
    }

    public Card setCardColor (Color cardColor) {
        this.cardColor = cardColor;
        return this;
    }

    public Suit getCardSuit ( ) {
        return cardSuit;
    }

    public Card setCardSuit (Suit cardSuit) {
        this.cardSuit = cardSuit;
        return this;
    }

    @Override
    public String toString ( ) {
        return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
                .add("cardRank=" + cardRank)
                .add("cardColor=" + cardColor)
                .add("cardSuit=" + cardSuit)
                .toString();
    }
}
