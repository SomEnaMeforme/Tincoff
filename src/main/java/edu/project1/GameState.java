package edu.project1;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    public final String word;
    public final Set<Character> guessedLetters = new HashSet<>();
    public final Set<Character> usedLetters = new HashSet<>();
    private int currentAttempt = 0;

    public GameState() {
        word = Words.getRandomWord();
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void newAttempt() {
        currentAttempt++;
    }

    public boolean isWordGuessed() {
        return word.chars().allMatch(x -> guessedLetters.contains((char) x));
    }
}
