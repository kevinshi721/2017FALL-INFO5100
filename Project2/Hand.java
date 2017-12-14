package com.kevinshi721.Project2;

import java.util.ArrayList;
import java.util.List;

public class Hand extends GroupOfCards {

    public int NUM;
    private int shortest;

    public Hand(int playerNumber, int numberOfCards) {
        super(numberOfCards);
        this.NUM = playerNumber;
    }

    public void sort() {
        for (int i = 0; i < getCards().size(); i++) {
            for (int j = i + 1; j < getCards().size(); j++) {
                Card x = getCards().get(i), y = getCards().get(j);
                if (x.compareWith(y) < 0) {
                    getCards().set(i, y);
                    getCards().set(j, x);
                }
            }
        }
    }

    public int getShortest() {
        return shortest;
    }

    public void setShortest() {
        this.shortest = 0;
        if (findCount(1) <= findCount(0)) {
            this.shortest = 1;
        }
        if (find(14, 3) == -1
                && find(13, 3) == -1
                && find(12, 3) == -1
                && findCount(3) <= findCount(0)
                && findCount(3) <= findCount(1)) {
            this.shortest = 3;
        }
    }

    public Card playACard(Game game, Trick trick) {
        int index = 0;
        if (trick.getCurrentSize() == 0) {
            if (findCount(shortest) > 0) {
                index = findHighest(shortest);
            } else {
                while (findCount(shortest) == 0) {
                    shortest = (shortest + 1) % 4;
                }
                index = findLowest(shortest);
            }
        } else {
            int suit = trick.getWinningCard().getSuit();
            if ((trick.getCurrentSize() == game.PLAYERS - 1)
                    && !trick.isHearts() && !trick.isQueen()
                    && (index = findLastHigh(suit)) >= 0) ;
            else if ((index = findHighestBelow(trick.getWinningCard())) >= 0) ;
            else if ((index = findMiddleHigh(game, suit)) >= 0) ;
            else if ((index = find(12, 3)) >= 0) ; // queen of Spades
            else if ((index = find(14, 3)) >= 0) ; // Ace of Spades
            else if ((index = find(13, 3)) >= 0) ; // King of Spades
            else if ((index = findHighest(2)) >= 0) ; // heart
            else {
                index = findHighest();
            }
        }
        Card card = removeCard(index);
        trick.update(NUM, card);
        return card;
    }

    private int findLastHigh(int suit) {
        int maxNum = -1;
        int index = -1;
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.getSuit() == suit
                    && card.getNum() > maxNum
                    && !(card.getSuit() == 3 && card.getNum() == 12)) {
                maxNum = card.getNum();
                index = i;
            }
        }
        return index;
    }

    private int findHighestBelow(Card winningCard) {
        int index = -1;
        if (findCount(winningCard.getSuit()) > 0) {
            List<Integer> indexList = new ArrayList<Integer>();
            for (int i = 0; i < getCards().size(); i++) {
                Card card = getCards().get(i);
                if (card.getSuit() == winningCard.getSuit() && card.getNum() < winningCard.getNum()) {
                    indexList.add(i);
                }
                if (indexList.size() > 1) {
                    index = indexList.get(0);
                }
            }
        }
        return index;
    }

    private int findMiddleHigh(Game game, int suit) {
        if (suit == 3 && !game.isQueenOfSpades()) {
            int maxNum = -1;
            int index = -1;
            for (int i = 0; i < getCards().size(); i++) {
                Card card = getCards().get(i);
                if (card.getSuit() == 3 && card.getNum() > maxNum && card.getNum() <= 11) {
                    maxNum = card.getNum();
                    index = i;
                }
            }
            return index;
        } else {
            return findHighest(suit);
        }
    }

    private int findHighest() {
        int maxNum = -1;
        int index = -1;
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.getNum() > maxNum) {
                maxNum = card.getNum();
                index = i;
            }
        }
        return index;
    }

    private int findHighest(int suit) {
        int maxNum = -1;
        int index = -1;
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.getSuit() == suit && card.getNum() > maxNum) {
                maxNum = card.getNum();
                index = i;
            }
        }
        return index;
    }

    public int findLowest(int suit) {
        int minNum = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.getSuit() == suit && card.getNum() < minNum) {
                minNum = card.getNum();
                index = i;
            }
        }
        return index;
    }

    private int findCount(int suit) {
        int count = 0;
        for (Card card : getCards()) {
            if (card.getSuit() == suit) {
                count ++;
            }
        }
        return count;
    }

    private int find(int num, int suit) {
        for (int i = 0; i < getCards().size(); i++) {
            Card card = getCards().get(i);
            if (card.getNum() == num && card.getSuit() == suit) {
                return i;
            }
        }
        return -1;
    }
} 
