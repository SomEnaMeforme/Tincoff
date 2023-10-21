package edu.project1;
import java.util.Scanner;
import java.awt.event.KeyEvent;

public class Game {

    private Game(int max_attempts) {
        MAX_ATTEMPTS_COUNT = max_attempts;
        state = new GameState();
    }
    private final int MAX_ATTEMPTS_COUNT;
    private final GameState state;
    public boolean isGameEnd() {
        if (state.isWordGuessed()) {
            endGame(true);
            return true;
        };
        if (state.getCurrentAttempt() > MAX_ATTEMPTS_COUNT) {
            endGame(false);
        }
        return false;
    }

    public static Game StartGame() {
        return new Game(9);
    }

    public void guess() {
        var chosenLetter = Console.guess();
        onGuess(chosenLetter);
        if (state.word.indexOf(chosenLetter) >= 0) {
            successGuess(chosenLetter);
        }
        else {
            failGuess();
        }
    }

    public void successGuess(char letter) {
        state.guessedLetters.add(letter);
        Console.printGuessResult(true);
    }

    public void failGuess() {
        state.newAttempt();
        Console.printGuessResult(false);
    }

    public void onGuess(char letter) {
        state.usedLetters.add(letter);
    }
    public void endGame(boolean isPlayerWin) {

    }

}
