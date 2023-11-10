package edu.project1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameState {
    public final String word;
    public final Set<Character> guessedLetters = new HashSet<>();
    public final Set<Character> usedLetters = new HashSet<>();
    private int currentAttempt = 0;
    private final StringBuilder displayedWord;
    private final HashMap<Character, HashSet<Integer>> symbolsIndexes;

    public GameState() {
        word = Words.getRandomWord();
        displayedWord = new StringBuilder();
        symbolsIndexes = new HashMap<>();
        var characters = word.toCharArray();
        for (var i = 0; i < word.length(); i++) {
            displayedWord.append("#");
            if (!symbolsIndexes.containsKey(characters[i])) {
                symbolsIndexes.put(characters[i], new HashSet<>());
            }
            symbolsIndexes.get(characters[i]).add(i);
        }
    }

    public int getCurrentAttempt() {
        return currentAttempt;
    }

    public void newAttempt() {
        currentAttempt++;
    }

    public String displayedWord() {
        return displayedWord.toString();
    }

    public void changeDisplayedWordOnSuccessGuess(Character guess) {
        var positions = symbolsIndexes.get(guess);
        for (var pos : positions) {
            displayedWord.setCharAt(pos, guess);
        }
    }

    public boolean isWordGuessed() {
        return word.chars().allMatch(x -> guessedLetters.contains((char) x));
    }
}
