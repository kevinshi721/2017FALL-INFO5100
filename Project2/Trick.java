package com.kevinshi721.Project2;

public class Trick extends GroupOfCards {

    private int winner;
    private Card winningCard;
    private boolean hearts;
    private boolean queen;


    public Trick(int players) {
        super(players);
    }

    public int getWinner() {
        return winner;
    }

    public Card getWinningCard() {
        return winningCard;
    }

    public boolean isHearts() {
        return hearts;
    }

    public boolean isQueen() {
        return queen;
    }

    public void update(int playNum, Card card) {
        addCard(card);
        if (winningCard == null) {
            winningCard = card;
            winner = playNum;
        } else if (winningCard.getSuit() == card.getSuit()) {
            winningCard = winningCard.getNum() > card.getNum() ? winningCard : card;
        }
    }

    public boolean isWinner(Card card) {
        return this.winningCard == card;
    }
}
