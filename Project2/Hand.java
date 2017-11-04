package com.kevinshi721.Project2;

public class Hand extends GroupOfCards {

    public int NUM;
    private int shortest;

    public Hand(int playerNumber, int numberOfCards) {
        super(numberOfCards);
        this.NUM = playerNumber;
    }

    public Card playACard(Game game, Trick trick) {
        Card card = removeCard(0);
        trick.update(NUM, card);
        return card;
    }
}
