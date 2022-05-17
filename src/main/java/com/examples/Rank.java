package com.examples;

public enum Rank {
    ACE("A",1,"Ace"),
    TWO("2",2,"Two"),
    THREE("3",3, "Three"),
    FOUR("4",4, "Four"),
    FIVE("5",5, "Five"),
    SIX("6",6,"Six"),
    SEVEN("7",7,"Seven"),
    EIGHT("8",8,"Eight"),
    NINE("9",9,"Nine"),
    TEN("10",10,"Ten"),
    JACK("J",10,"Jack"),
    QUEEN("Q",10,"Queen"),
    KING("K",10,"King");

    private final int value;
    private final String symbol;
    private final String description;

    private Rank(String symbol,int value,String description) {
        this.symbol = symbol;
        this.value = value;
        this.description = description;
    }

    public String getSymbol() { return symbol; }
    public int getValue ( ) {
        return value;
    }
    public String getDescription() { return description; }
}
