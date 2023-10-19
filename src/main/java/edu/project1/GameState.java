package edu.project1;

public class GameState {
    public boolean isGameEnd() {
        return current_attempt < MAX_ATTEMPTS_COUNT;
    }

    private final int MAX_ATTEMPTS_COUNT = 9;
    private int current_attempt = 1;
    private String word = "";

    public void Guess(char choicedLetter) {
        if (word.indexOf(choicedLetter) >= 0) {
            SuccessGuess();
        } else {
            FailGuess();
        }
        OnGuess();

    }

    public void SuccessGuess() {

    }

    public void FailGuess() {
        current_attempt++;
    }

    public void OnGuess() {

    }
}
