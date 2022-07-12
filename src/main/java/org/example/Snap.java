package org.example;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame{

    public Snap() {
        super("Snap");
    }

    // Fields
    private boolean hasMatch = false;
    private Card cardOne;
    private Card cardTwo;
    private ArrayList<Card> discardPile = new ArrayList<>();

    // Accessing Fields
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

    // Initialise Players
    Player playerOne = new Player("Player One", 1);
    Player playerTwo = new Player("Player Two", 2);
    Player currentPlayer = playerOne;

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

    // Player operations for Snap game
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

    // Methods only for Snap game
    public void checkWin() {
        if (Objects.equals(cardOne.getSuit(), cardTwo.getSuit())) {
            printMessage("MATCH!");
            printMessage(currentPlayer.getName() + " wins!\n");
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            setHasMatch(true);
        } else {
            printMessage("NO MATCH \n");
        }
    }

    public void changePlayers() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
    }

    // Function used for timer!!!
    public void getStringInput() {
        boolean isActive = true;
        while (isActive) {
            printMessage("Type 'snap' if the suits match!");
            Scanner scanner = getScanner();
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("snap")) {
                checkWin();
            } else {
                printMessage("Invalid input");
            }
            isActive = false;
        }
    }

    public void checkScore() {
        printMessage("Score:");
        printMessage(playerOne.getName() + ": " + playerOne.getScore());
        printMessage(playerTwo.getName() + ": " + playerTwo.getScore() + "\n");
    }

    public void startGame() {
        printGreeting();
        DeckOfCards.setDeckOfCards(DeckOfCards.shuffleDeck());
        playerOneTurnStart();
        playerTwoTurn();
        checkWin();
        currentPlayer = playerOne;
    }

    public void snapGame() {
        while (!hasMatch) {
            if (Objects.equals(currentPlayer.getName(), playerOne.getName())) {
                playerOneTurn();
            } else {
                playerTwoTurn();
            }
            checkWin();
            discardPile.add(cardOne);
            setCardOne(cardTwo);
            changePlayers();
        }
    }

    @Override
    public void run() {
        hasMatch = false;
        startGame();
        snapGame();
    }
}