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

    Player playerOne = new Player("Player One", 1);
    Player playerTwo = new Player("Player Two", 2);
    Player currentPlayer = playerOne;

    public void playerOneTurnStart() {
        printMessage("Player 1's Turn:");
        currentPlayer = playerOne;
        setCardOne(dealTurn());
        playerOne.setCard(cardOne);
        printStatus(cardOne);
    }

    public void playerOneTurn() {
        printMessage("Player 1's Turn:");
        currentPlayer = playerOne;
        setCardTwo(dealTurn());
        playerOne.setCard(cardTwo);
        printStatus();
    }

    public void playerTwoTurn() {
        printMessage("Player 2's Turn:");
        currentPlayer = playerTwo;
        setCardTwo(dealTurn());
        playerTwo.setCard(cardTwo);
        printStatus();
    }

    public void checkWin() {
        if (Objects.equals(cardOne.getSuit(), cardTwo.getSuit())) {
            printMessage("MATCH!");
            printMessage(currentPlayer.getName() + " Wins!");
            setHasMatch(hasMatch);
        } else {
            printMessage("NO MATCH \n");
        }
    }

    @Override
    public void run() {
        printGreeting();
        DeckOfCards.setDeckOfCards(DeckOfCards.shuffleDeck());
        playerOneTurnStart();
        playerTwoTurn();
        checkWin();
        currentPlayer = playerOne;
        while (!hasMatch) {
            if (Objects.equals(currentPlayer.getName(), playerOne.getName())) {
                playerOneTurn();
            } else {
                playerTwoTurn();
            }
            checkWin();

            discardPile.add(cardOne);
            setCardOne(cardTwo);

            if (currentPlayer == playerOne) {
                currentPlayer = playerTwo;
            } else {
                currentPlayer = playerOne;
            }
        }
    }
}
