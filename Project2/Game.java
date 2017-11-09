package com.kevinshi721.Project2;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public int PLAYERS;
    private int TOTAL_NUMBER_OF_TRICKS;
    private Deck deck;
    private List<Hand> players;
    private List<Trick> tricks;
    private boolean hearts;
    private boolean queenOfSpades;
    private int playerNum;

    public Game(int numberOfPlayers) {
        this.PLAYERS = numberOfPlayers;
        this.TOTAL_NUMBER_OF_TRICKS = Deck.TOTAL_CARDS / this.PLAYERS;
        this.players = new ArrayList<Hand>(numberOfPlayers);
        for (int i = 0; i < PLAYERS; i++) {
            players.add(new Hand(i, TOTAL_NUMBER_OF_TRICKS));
        }
        this.tricks = new ArrayList<Trick>(TOTAL_NUMBER_OF_TRICKS);
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
        int currentPlayerNum = 0;
        this.deck.shuffle();
        for (int i = 0; i < TOTAL_NUMBER_OF_TRICKS; i++) {
            for (Hand player : players) {
                player.addCard(deck.dealCard());
            }
        }
        int lowestClub = Integer.MAX_VALUE;
        for (Hand player : players) {
            player.sort();
            player.setShortest();
            int index = player.findLowest(0);
            if (index >= 0) {
                Card card = player.getCards().get(index);
                if (card.getNum() < lowestClub) {
                    lowestClub = card.getNum();
                    currentPlayerNum = player.NUM;
                }
            }
        }
        displayFirstPartResult();

        for (int i = 0; i < TOTAL_NUMBER_OF_TRICKS; i++) {
            Trick trick = new Trick(PLAYERS);
            this.tricks.add(trick);

            if (i == 0) {
                Hand player = players.get(currentPlayerNum);
                Card card = player.removeCard(player.findLowest(0));
                trick.update(player.NUM, card);
                updateHeartsAndQueen(card);
                System.out.printf("player %d\t\t%s\n", player.NUM, card);
                currentPlayerNum = (currentPlayerNum + 1) % PLAYERS;
            }
            while (trick.getCurrentSize() < PLAYERS) {
                Hand player = players.get(currentPlayerNum);
                Card card = player.playACard(this, trick);
                updateHeartsAndQueen(card);
                System.out.printf("player %d\t\t%s\n", player.NUM, card);
                currentPlayerNum = (currentPlayerNum + 1) % PLAYERS;
            }
            if (i == 0 && deck.getCurrentSize() > 0) {
                while (deck.getCurrentSize() > 0) {
                    Card card = deck.dealCard();
                    trick.addCard(card);
                    updateHeartsAndQueen(card);
                    System.out.printf("undelt card\t\t%s\n", card);
                }
            }
            currentPlayerNum = trick.getWinner();
            System.out.println();
        }

        for (Hand player : this.players) {
            System.out.printf("Player %d score= %d\n", player.NUM, computePoints(player.NUM));
        }
    }

    private void displayFirstPartResult() {
        for (Hand player : players) {
            System.out.printf("\t\tplayer %d shortest= %d\n", player.NUM, player.getShortest());
            for (Card card : player.getCards()) {
                card.display();
            }
        }
        System.out.println();
    }

    public void updateHeartsAndQueen(Card card) {
        if (card.getSuit() == 2) {
            if (!this.isHearts()) {
                System.out.println("Hearts is now broken");
            }
            this.hearts = true;
        } else if (card.getSuit() == 3 && card.getNum() == 12) {
            this.queenOfSpades = true;
        }
    }

    private int computePoints(int playerNum) {
        int result = 0;
        for (Trick trick : this.tricks) {
            if (trick.getWinner() == playerNum) {
                for (Card card : trick.getCards()) {
                    if (card.getSuit() == 2) {
                        result += 1;
                    } else if (card.getSuit() == 3 && card.getNum() == 12) {
                        result += 13;
                    }
                }
            }
        }
        return result;
    }
}
