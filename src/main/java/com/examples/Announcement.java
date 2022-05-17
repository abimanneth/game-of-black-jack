package com.examples;

import java.util.Scanner;

public final class Announcement {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
     public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public void banner(){
        System.out.printf("%n%s%s%s%n",ANSI_RED_BACKGROUND,"WELCOME TO BLACK JACK 1.0",ANSI_RESET);
        System.out.printf("%32s%n","This is an attempt to build BLACK JACK, game of 52 cards,\nwhere the dealer and player will given initially 2 cards \nif the card rank equals 21, then the player  will win,\nif player want more cards he/she can hit or stand.\n");
    }

    public void winner (AbstractPlayer player) {
        System.out.println("!!!CONGRATULATION!!!");
        System.out.printf("%s%s%s%s%n","The winner is ",ANSI_GREEN,player.getPlayerName(),ANSI_RESET);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
    }
    public String read(String message) {
        System.out.println(message);
      Scanner scanner = new Scanner(System.in);
      String text = scanner.findInLine("[a-zA-Z ]+");
      return text;
    }
    public void announce(final String message){
        System.out.println(message);
    }

    public void bust (String message) {
        System.out.printf("%s%s%s%n",ANSI_RED,message,ANSI_RESET);
    }
    public void scoreboard(final int rankOfDealer, final int rankOfPlayer) {
        System.out.printf("%n%s%s%n",ANSI_GREEN,"****************************************************");
        System.out.printf("%s%n","Score Board: Dealer:"+rankOfDealer+", Player:"+rankOfPlayer);
        System.out.printf("%s%s%n","****************************************************",ANSI_RESET);
    }
}
