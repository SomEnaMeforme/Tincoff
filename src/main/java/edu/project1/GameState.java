package edu.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    public final String word;
    public final Set<Character> guessedLetters = new HashSet<Character>();
    public final Set<Character> usedLetters = new HashSet<Character>();
    private int current_attempt = 1;

    public GameState() {
        word = Words.getRandomWord();
    }

    public int getCurrentAttempt() {
        return current_attempt;
    }
    public void newAttempt() {
        current_attempt++;
    }

    public boolean isWordGuessed() {
        return guessedLetters.containsAll(Arrays.asList(word.toCharArray()));
    }
}
