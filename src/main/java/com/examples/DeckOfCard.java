package com.examples;

import java.util.*;
import java.util.concurrent.SynchronousQueue;

public class DeckOfCard {
    public static List<Card> deckOfCard = new ArrayList<>();

    public void createCards(){
        String[] symbols = {"Club","Heart","Diamond","Spade"};
        for (Suit suit : Suit.values()) {
           Color color = (suit == Suit.HEARTS || suit == Suit.DIAMONDS) ? Color.RED : Color.BLACK;
            for (Rank rank: Rank.values()) {
                deckOfCard.add(new Card(rank, color, suit));
            }
        }
    }
    public List<Card> shuffle ( ){
        List<Card> keys = new ArrayList<>(deckOfCard);
        Collections.shuffle(keys, new Random(new Date().getTime()));
        return keys;
    }

    public static void main (String[] args) {
        Announcement announcement = new Announcement();
        announcement.banner();
        do {
            new DeckOfCard().createCards();
            List<Card> cards = new DeckOfCard().shuffle();
            String name = announcement.read("Enter player name.");
            Dealer dealer = new Dealer();
            Player player = new Player(name);
            player.play(cards, 2);
            dealer.play(cards, 2);
            new CardPlayDetermination().hitOrBurst(dealer, player, cards);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you to continue if no please Y/y key or else any key to continue..");
            String text = scanner.findInLine("(Y|y)");
            if (!"Y".equalsIgnoreCase(text)) break;
        } while (true);
    }
}
