package org.example;

public class HomeCommands extends Commands{
    public HomeCommands() {
        super("Home", new String[]{"New Game", "Check Score", "Quit"}, "home");
    }

    @Override
    public void run() {
        printGreeting();
        printCommands();

        int userInput = getIntegerInput();

        switch (userInput) {
            case 1:
                setNextCommand("newGame");
                break;
            case 2:
                setNextCommand("checkScore");
                break;
            default:
                setNextCommand("");
        }
    }
}
