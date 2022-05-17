package com.examples;

import java.util.List;
import java.util.Scanner;

public class CardPlayDetermination {
    public int totalRank (List<Card> cardList ) {
        int sum = 0, count = 0;
        for (Card card: cardList) {
            int value = card.getCardRank().getValue();
            if(card.getCardRank() == Rank.ACE) {
               value = count++ >= 1 ? value: 11;
            }
            sum += value;
        }
        return sum;
    }

    public void hitOrBurst (Dealer dealer, Player player, List<Card> shuffledCards ) {
        System.out.println("Please key HIT (h/H) or STAND (s/S)");
        Scanner scanner = new Scanner(System.in);
        String answer    = scanner.findInLine("(s|S|h|H)");

        if ("S".equalsIgnoreCase(answer)) {
            onStand(dealer, player,shuffledCards);
        } else if ("H".equalsIgnoreCase(answer)) {
            player.play(shuffledCards,1);
            hitOrBurst(dealer, player,shuffledCards);
        } else {
            ;
        }
    }
    public void onStand(Dealer dealer, Player player,List<Card> shuffleCards) {
        int count        = player.getCardList().size() - dealer.getCards().size();
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            flag = determineWinner(dealer,player,shuffleCards);
            if (flag) {
                break;
            }
        }
        announceWinner(dealer,player,shuffleCards);
    }
    public boolean determineWinner (Dealer dealer, Player player,final List<Card> shuffleCards){
        int rankOfDealer = totalRank(dealer.getCards());
        int rankOfPlayer = totalRank(player.getCardList());
        System.out.println(rankOfDealer+":"+rankOfPlayer);
        boolean flag = false;

        if (rankOfPlayer >= 21 || rankOfDealer >= 21) {
           flag = true;
        } else {
             dealer.play(shuffleCards,1);
        }
        return flag;
    }
    public void announceWinner(Dealer dealer,Player player, List<Card> cardList){
        int rankOfDealer = totalRank(dealer.getCards());
        int rankOfPlayer = totalRank(player.getCardList());
        Announcement announcement    =   new Announcement();
        announcement.scoreboard(rankOfDealer,rankOfPlayer);
        if (rankOfPlayer > 21 && rankOfDealer > 21) {
            announcement.bust("Both the Dealer and Player bust.");
        } else if (rankOfPlayer == 21 || rankOfDealer == 21) {
            new Announcement().winner(rankOfPlayer == 21 ? player:dealer);
        } else {
            int max = Math.max(rankOfDealer,rankOfPlayer);
            if ((rankOfDealer < 17 || rankOfDealer > 21) && (rankOfPlayer < 17 || rankOfPlayer > 21)) {
                announcement.bust("Both the Dealer and Player bust.");
            } else {
                announcement.winner(rankOfPlayer >= max && max <= 21 ? player : dealer);
            }
        }
    }
}
