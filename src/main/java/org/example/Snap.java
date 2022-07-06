package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Snap extends CardGame{

    public Snap() {
        super("Snap");
    }

    private boolean hasMatch = false;
    private Card cardOne;
    private Card cardTwo;

    private ArrayList<Card> discardPile = new ArrayList<>();

    public Card getCardOne() {
        return cardOne;
    }

    public void setCardOne(Card cardOne) {
        this.cardOne = cardOne;
    }

    public Card getCardTwo() {
        return cardTwo;
    }

    public void setCardTwo(Card cardTwo) {
        this.cardTwo = cardTwo;
    }

    public void setHasMatch(boolean hasMatch) {
        this.hasMatch = hasMatch;
    }

    public Card dealTurn() {
        getEnterInput();
        return DeckOfCards.dealCard();
    }

    public void printStatus() {
        printMessage("Current Deck:\n");
        printMessage("Last Card: " + cardOne.getId());
        printMessage("This Card: " + cardTwo.getId());
        printMessage("\n");
    }

    public void printStatus(Card card) {
        printMessage("Current Deck:\n");
        printMessage("This Card: " + card.getId());
        printMessage("\n");
    }

    @Override
    public void run() {
        printGreeting();
        DeckOfCards.setDeckOfCards(DeckOfCards.shuffleDeck());
        setCardOne(dealTurn());
        printStatus(cardOne);
        while (!hasMatch) {
            setCardTwo(dealTurn());
            printStatus();
            if (Objects.equals(cardOne.getSuit(), cardTwo.getSuit())) {
                printMessage("MATCH!");
                printMessage("You Win!");
                break;
            } else {
                printMessage("NO MATCH");
            }
            discardPile.add(cardOne);
            setCardOne(cardTwo);
        }
    }
}
