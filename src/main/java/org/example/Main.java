package org.example;

public class Main {
    public static void main(String[] args) {
        Snap snapGame = new Snap();
        HomeCommands homeCommands = new HomeCommands();
        homeCommands.run();

        boolean isActive = true;
        while (isActive) {
            switch (homeCommands.getNextCommand()) {
                case "newGame":
                    snapGame.run();
                    homeCommands.setNextCommand("home");
                    break;
                case "checkScore":
                    snapGame.checkScore();
                    homeCommands.setNextCommand("home");
                    break;
                case "home":
                    homeCommands.run();
                    break;
                default:
                    isActive = false;
                    break;
            }
        }
    }
}