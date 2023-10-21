package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    private Console() {}
    private final static Scanner consoleInput = new Scanner(System.in);
    private final static Logger LOGGER = LogManager.getLogger();

    public static char guess() {
        LOGGER.info("Guess the letter: ");
        return consoleInput.nextLine().charAt(0);
    }
    public static void startGame() {
        LOGGER.info("Game started!");
    }

    public static void printWord(GameState state) {
        var encryptedWord = new StringBuilder();
        for (var symbol : state.word.toCharArray()) {
            encryptedWord.append(state.guessedLetters.contains(symbol) ? symbol : "#");
        }
        LOGGER.info(encryptedWord);
    }
    public static void printGuessResult(boolean isSuccessGuess) {

    }

    public static void playerWin() {

    }

    public static void playerLose() {

    }
}
