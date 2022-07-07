package org.example;//package org.example;
import java.util.Scanner;

public abstract class CardGame {
    private final String name;
    private final Scanner scanner;

    public CardGame(String name) {
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    abstract public void run();

    public void printGreeting() {
        System.out.println("Let's play " + name + "!");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void getEnterInput() {
        boolean isActive = true;
        while (isActive) {
            System.out.println("Press Enter");
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                isActive = !isActive;
            }
        }
    }
}