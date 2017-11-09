package com.kevinshi721.Project2;

import java.util.Random;

public class Deck extends GroupOfCards {

    public static final int TOTAL_CARDS = 52;

    public Deck() {
        super(TOTAL_CARDS);
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                addCard(new Card(j, i));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int index1 = random.nextInt(TOTAL_CARDS);
            int index2 = random.nextInt(TOTAL_CARDS);

            Card card1 = getCards().get(index1);
            Card card2 = getCards().get(index2);
            getCards().set(index1, card2);
            getCards().set(index2, card1);
        }
    }

    public Card dealCard() {
        return removeCard(0);
    }
}
