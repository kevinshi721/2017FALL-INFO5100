package com.kevinshi721.Project2;

public class Card {

    private static final String[] numDisplayName = new String[] {
            "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };

    private static final String[] suitDisplayName = new String[] {
            "clubs", "diamonds", "hearts", "spades"
    };

    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public void display() {
        String displayNum = numDisplayName[num - 2];
        String displaySuit = suitDisplayName[suit];
        System.out.printf("%s of %s\n", displayNum, displaySuit);
    }
}
