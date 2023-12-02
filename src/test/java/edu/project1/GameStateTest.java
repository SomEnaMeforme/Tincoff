package edu.project1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameStateTest {
    @Test
    public void whenCreateStateCreateWordForGameTest()
    {
        var state = new GameState();
        assertThat(state.word == null).isFalse();
    }
    @Test
    public void newAttemptIncreaseAttemptsByOneTest()
    {
        var state = new GameState();
        state.newAttempt();
        assertThat(state.getCurrentAttempt()).isEqualTo(1);
    }
    @Test
    public void isWordGuessedCorrectWorkTest() {
        var state = new GameState();
        for (var symb : state.word.toCharArray())
            state.guessedLetters.add(symb);
        assertThat(state.isWordGuessed()).isTrue();
    }

    @Test
    public void isWordGuessedCorrectWorkWhenGuessedLettersEmptyTest() {
        var state = new GameState();
        assertThat(state.isWordGuessed()).isFalse();
    }

}
