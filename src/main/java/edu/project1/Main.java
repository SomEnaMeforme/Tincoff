package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.project1.GameState;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {

        LOGGER.info("Hello and welcome!");
        var game = Game.StartGame();
        while (!game.isGameEnd()) {
            game.guess();
        }

    }
}
