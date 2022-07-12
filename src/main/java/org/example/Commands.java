package org.example;

import java.util.Scanner;

public abstract class Commands {
    private final String name;
    private final String[] commands;
    private final Scanner scanner;
    private String nextCommand;

    public Commands(String name, String[] commands, String nextCommand) {
        this.name = name;
        this.commands = commands;
        this.scanner = new Scanner(System.in);
        this.nextCommand = nextCommand;
    }

    public String getName() {
        return name;
    }

    public String[] getCommands() {
        return commands;
    }

    public String getNextCommand() {
        return nextCommand;
    }

    public void setNextCommand(String nextCommand) {
        this.nextCommand = nextCommand;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printCommands() {
        for (int i = 0; i < commands.length; i++) {
            printMessage((i + 1) + " : " + commands[i]);
        }
    }

    public void printGreeting() {
        printMessage("Welcome to my Snap game");
    }

    public int getIntegerInput() {
        boolean isActive = true;
        int input = 0;
        while (isActive) {
            printMessage("Enter the corresponding number:");
            int userInput = scanner.nextInt();
            if (userInput > 0 && userInput <= commands.length) {
                isActive = false;
                input = userInput;
            } else {
                printMessage("Invalid input");
            }
        }
        scanner.nextLine();
        return input;
    }

    abstract public void run();

}
