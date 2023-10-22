package edu.project1;

import edu.hw1.task0_task1.Task0;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        LOGGER.info("Hello and welcome!");
        var game = Game.startGame();
        while (!game.isGameEnd()) {
            game.guess();
        }

    }
}
