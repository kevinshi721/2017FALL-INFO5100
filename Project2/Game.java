package com.kevinshi721.Project2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public int PLAYERS;
    private Deck deck;
    private List<Hand> players;
    private List<Trick> tricks;
    private boolean hearts;
    private boolean queenOfSpades;


    public Game(int numberOfPlayers) {
        this.PLAYERS = numberOfPlayers;
        this.players = new ArrayList<>(numberOfPlayers);
        int numberOfTricks = Deck.TOTAL_CARDS / PLAYERS;
        for (int i = 0; i < PLAYERS; i++) {
            players.add(new Hand(i, numberOfTricks));
        }
        this.tricks = new ArrayList<>(numberOfTricks);
        this.deck = new Deck();
    }

    public int getNumberOfTricks() {
        return this.tricks.size();
    }

    public boolean isHearts() {
        return hearts;
    }

    public boolean isQueenOfSpades() {
        return queenOfSpades;
    }

    public void playAGame() {
        this.deck.shuffle();
        for (int i = 0; i < getNumberOfTricks(); i++) {
            for (Hand player : players) {
                player.addCard(deck.dealCard());
            }
        }
    }


}
