package edu.project1;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class Console {
    private Console() {
    }

    public static void setStream(InputStream stream) {
        consoleInput = new Scanner(stream);
    }

    private static Scanner consoleInput = new Scanner(System.in);
    private final static Logger LOGGER = LogManager.getLogger();

    public static String guess() throws NoSuchElementException, IndexOutOfBoundsException {
        LOGGER.info("Guess the letter: ");
        return consoleInput.nextLine();
    }

    public static void logStartGame() {
        LOGGER.info("Game started!");
    }

    public static void printWord(@NotNull String displayedWord) {
        LOGGER.info(displayedWord);
    }

    public static void printGuessResult(boolean isSuccessGuess) {
        LOGGER.info(isSuccessGuess ? "Hit!" : "Missed");
    }

    public static void printRemainingAttempts(int maxAttempts, int remainingAttempts) {
        LOGGER.info(String.format("Left %d attempts out of %d", remainingAttempts, maxAttempts));
    }

    public static void playerWin() {
        LOGGER.info("You won!");
    }

    public static void playerLose() {
        LOGGER.info("You lost!");
    }
}
