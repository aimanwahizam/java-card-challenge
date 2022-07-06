package org.example;

import java.util.Comparator;

public class Card{
    private String symbol;
    private int value;
    private String id;
    private String suit;
    private static final String[] symbolArray = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final int[] valueArray = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    private static final String[] suitArray = new String[]{"\u2664", "\u2661", "\u2667", "\u2662"};

    public Card(String symbol, int value, String id, String suit) {
        this.symbol = symbol;
        this.value = value;
        this.id = id;
        this.suit = suit;
    }

    public String getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public static String[] getSymbolArray() {
        return symbolArray;
    }

    public static int[] getValueArray() {
        return valueArray;
    }

    public static String[] getSuitArray() {
        return suitArray;
    }

    @Override
    public String toString() {
        return "Card {" +
                "symbol = " + symbol +
                ", value = " + value +
                ", id= " + id +
                '}';
    }
}
