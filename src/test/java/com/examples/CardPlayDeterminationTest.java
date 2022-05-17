package com.examples;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CardPlayDeterminationTest {

    CardPlayDetermination cardPlayDetermination;
    List<Card> cardList;
    List<Card> cardListOfPlayer;
    List<Card> cardListOfDealer;
    Dealer dealer;
    Player player;

    @Before
    public void setup(){
        new DeckOfCard().createCards();
        cardList    = new DeckOfCard().shuffle();

        cardPlayDetermination = new CardPlayDetermination();
        cardListOfPlayer = new ArrayList<>();
        cardListOfPlayer.add(new Card(Rank.ACE,Color.BLACK,Suit.CLUBS));
        cardListOfPlayer.add(new Card(Rank.NINE,Color.BLACK,Suit.SPADES));
        cardListOfPlayer.add(new Card(Rank.ACE,Color.RED,Suit.DIAMONDS));

        cardListOfDealer = new ArrayList<>();
        cardListOfDealer.add(new Card(Rank.EIGHT,Color.BLACK,Suit.CLUBS));
        cardListOfDealer.add(new Card(Rank.FIVE,Color.BLACK,Suit.SPADES));
        cardListOfDealer.add(new Card(Rank.QUEEN,Color.RED,Suit.DIAMONDS));
    }
    @Test
    public void testTotalRankWhenListOfCardIsEmpty() {
        int sum = cardPlayDetermination.totalRank(Collections.EMPTY_LIST);
        int expected = 0;
        assertEquals("Output expected is zero.",expected,sum);
    }

    @Test
    public void testTotalRankWhenListOfCardHasTwoAces() {
        int sum = cardPlayDetermination.totalRank(cardListOfPlayer);
        int expected = 21;
        assertEquals("Output expected is 21.",expected,sum);
    }

    @Test
    public void testDetermineWhoIsWinner ( ) {
        dealer = new Dealer("Dealer");
        player = new Player("Demo");
        dealer.setCards(cardListOfDealer);
        player.setCardList(cardListOfPlayer);
        boolean expected = false;

        boolean output = cardPlayDetermination.determineWinner(dealer,player,cardList);
        assertEquals("",expected,output);
    }

    @After
    public void tearDown(){
        if (cardList != null) cardList.clear();
        if (cardListOfPlayer != null) cardListOfPlayer.clear();
        if (cardListOfDealer != null) cardListOfDealer.clear();
    }
}