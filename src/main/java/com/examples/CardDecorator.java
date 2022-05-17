package com.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CardDecorator {
    private static final char UNICODE_SYMBOL_FOR_SPADE = '\u2660';
    private static final char UNICODE_SYMBOL_FOR_HEART = '\u2665';
    private static final char UNICODE_SYMBOL_FOR_CLUB = '\u2663';
    private static final char UNICODE_SYMBOL_FOR_DIAMOND = '\u2666';
    private static final int  DECK_CARD_WIDTH            = 12;
    private static final int  DECK_CARD_HEIGHT           = 4;

    private  void decorateCardBorder(final int noOfCardsToDecorate) {
        for (int i = 0; i < noOfCardsToDecorate; i++) {
            for (int j = 0; j < DECK_CARD_WIDTH; j++) {
                if (j == 0 || j == DECK_CARD_WIDTH - 1) {
                        System.out.printf("%s", ":");
                } else {
                    System.out.printf("%s", "-");
                }
            }
            System.out.printf("%3s","");
        }
        System.out.printf("%n");
    }
    private static void decorateCardBody (final int noOfCardsToDecorate, List<Card> listOfCards) {
       int k = 0;
        for (int i = 1; i <= DECK_CARD_HEIGHT; i++) {
            while (k < noOfCardsToDecorate) {
                Card card = listOfCards.get(k);
                String description = card.getCardRank().getSymbol();
                String color = card.getCardColor().toString();
                String symbol = card.getCardSuit().toString();
                for (int j = 1; j <= DECK_CARD_WIDTH; j++) {
                    if (j == 1 || j == DECK_CARD_WIDTH){
                        System.out.printf("%s","|");
                    }else{
                        cardSymbol(i,j,symbol,description);
                    }
                }
                System.out.printf("%3s"," ");
                k++;
            }
            k = 0;
            System.out.println();
        }
    }
    private static void cardSymbol(int i, int j, String symbol,String description) {
        char symb;
        if ("SPADES".equals(symbol)) {
            symb = UNICODE_SYMBOL_FOR_SPADE;
        } else if ("CLUBS".equals(symbol)) {
            symb = UNICODE_SYMBOL_FOR_CLUB;
        } else if ("HEARTS".equals(symbol)) {
            symb = UNICODE_SYMBOL_FOR_HEART;
        } else if ("DIAMONDS".equals(symbol)) {
            symb = UNICODE_SYMBOL_FOR_DIAMOND;
        } else {
            symb = '\u0000';
        }
        if (i == (DECK_CARD_HEIGHT / 2)   && j == (DECK_CARD_WIDTH / 2)) {
            System.out.print(symb);
        } else {
            if ((i == 1 && j == 3) || (j ==  11 && i == 4)) {
                System.out.printf("%s",description);
            } else {
                System.out.print(" ");
            }
        }
    }
    public void cards(int count, List<Card> cards) {
        decorateCardBorder(count);
        decorateCardBody(count, cards);
        decorateCardBorder(count);
    }
}
