package com.kevinshi721.Project2;

import java.util.ArrayList;
import java.util.List;

public class GroupOfCards {

    private List<Card> cards;
    private int currentSize;

    public GroupOfCards() {
    }

    public GroupOfCards(int num) {
        this.cards = new ArrayList<>(num);
        this.currentSize = num;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.currentSize ++;
    }

    public Card removeCard(int index) {
        Card card = null;
        if (currentSize > 0) {
            card = this.cards.remove(index);
            this.currentSize--;
        }
        return card;
    }

    public void display() {
        for (Card card : cards) {
            card.display();
        }
    }
}
