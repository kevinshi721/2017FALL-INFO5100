package com.kevinshi721.Project2;

public class GameDriver {

    private Game game;

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        deck.display();
    }
}
