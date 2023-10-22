package edu.project1;

import java.util.NoSuchElementException;

public class Game {

    private Game() {
        state = new GameState();
    }

    private final int maxAttemptsCount = 9;
    private final GameState state;
    private boolean earlyCompletion = false;

    public boolean isGameEnd() {
        return state.getCurrentAttempt() >= maxAttemptsCount || state.isWordGuessed() || earlyCompletion;
    }

    public static Game startGame() {
        Console.logStartGame();
        return new Game();
    }

    public void guess() {
        Console.printWord(state.word, state.guessedLetters);
        char chosenLetter;
        boolean invalidInput;
        try {
            var input = Console.guess();
            invalidInput = input.length() > 1;
            chosenLetter = input.charAt(0);
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) {
                giveUp();
            } else {
                failGuess();
            }
            return;
        }
        if (!invalidInput && state.word.indexOf(chosenLetter) >= 0 && !state.usedLetters.contains(chosenLetter)) {
            successGuess(chosenLetter);
        } else {
            failGuess();
        }
        if (!invalidInput) {
            onGuess(chosenLetter);
        }
    }

    private void successGuess(char letter) {
        state.guessedLetters.add(letter);
        Console.printGuessResult(true);
        if (state.isWordGuessed()) {
            endGame(true);
        }
    }

    private void failGuess() {
        state.newAttempt();
        Console.printGuessResult(false);
        Console.printRemainingAttempts(maxAttemptsCount, getRemainingAttemptsCount());
        if (state.getCurrentAttempt() >= maxAttemptsCount) {
            endGame(false);
        }
    }

    public int getRemainingAttemptsCount() {
        return maxAttemptsCount - state.getCurrentAttempt();
    }

    private void onGuess(char letter) {
        state.usedLetters.add(letter);
    }

    private void endGame(boolean isPlayerWin) {
        if (isPlayerWin) {
            Console.playerWin();
        } else {
            Console.playerLose();
        }

    }

    private void giveUp() {
        earlyCompletion = true;
        endGame(false);
    }

    //Нужен для тестов
    public GameState getState() {
        return state;
    }
}
