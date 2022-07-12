package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class DeckOfCards {
    private static ArrayList<Card> deckOfCards = new ArrayList<>(52);

    // Static Constructor
    static {
        for (int i = 0; i < Card.getSuitArray().length; i++) {
            for (int j = 0; j < Card.getValueArray().length; j++) {
                 Card card = new Card(Card.getSymbolArray()[j], Card.getValueArray()[j], Card.getSymbolArray()[j] + "-" + Card.getSuitArray()[i], Card.getSuitArray()[i]);
                deckOfCards.add(card);
            }
        }
    }

    public static void setDeckOfCards(ArrayList<Card> deckOfCards) {
        DeckOfCards.deckOfCards = deckOfCards;
    }

    public static void getDeck() {
        for (Card deckOfCard : deckOfCards) {
            System.out.println(deckOfCard.toString());
        }
    }

    public static Card dealCard() {
        Card drawnCard = deckOfCards.get(0);
        deckOfCards.remove(0);
        return drawnCard;
    }

    public static ArrayList<Card> sortDeckInNumberOrder() {
        return (ArrayList<Card>) deckOfCards.stream()
                .sorted(Comparator.comparing(Card::getValue))
                .collect(Collectors.toList());
    }

    public static ArrayList<Card> sortDeckInSuitOrder() {
        return (ArrayList<Card>) deckOfCards.stream()
                .sorted(Comparator.comparing(Card::getSuit))
                .collect(Collectors.toList());
    }

    public static ArrayList<Card> shuffleDeck() {
        ArrayList<Card> shuffledDeck = deckOfCards;
        Collections.shuffle(shuffledDeck);
        return shuffledDeck;
    }
}
