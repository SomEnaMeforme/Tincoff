package edu.project1.GameTest;

import edu.project1.Console;
import edu.project1.Game;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GuessMethodTest {

    private Game getGameAndSetInputToGuess(String input) {
        var game = Game.startGame();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Console.setStream(in);
        game.guess();
        return game;
    }
    private void setInputToGuess(String input, Game game) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        Console.setStream(in);
        game.guess();
    }
    @Test
    public void guessInputContainsMoreThanOneLetterWastesAttempt() {
        var game = getGameAndSetInputToGuess("dfghdgjk");
        assertThat(game.getRemainingAttemptsCount()).isEqualTo(8);
    }
    @Test
    public void guessInputContainsLessThanOneLetterWastesAttempt() {
        var game = getGameAndSetInputToGuess("\n");
        assertThat(game.getRemainingAttemptsCount()).isEqualTo(8);
    }
    @Test
    public void guessNoSuchElExceptionEndGame() {
        var game = getGameAndSetInputToGuess("");
        assertThat(game.isGameEnd()).isTrue();
    }
    @Test
    public void guessWhenChosenWrongLetterWasteAttemptTest() {
        var game = getGameAndSetInputToGuess("z");;
        assertThat(game.getRemainingAttemptsCount()).isEqualTo(8);
    }
    @Test
    public void guessAddLetterToUsedLettersTest() {
        var game = getGameAndSetInputToGuess("z");;
        assertThat(game.getState().usedLetters.contains('z')).isTrue();
    }
    @Test
    public void guessWhenChosenRightLetterAddLetterToGuessedLettersTest() {
        var game = getGameAndSetInputToGuess("a");;
        assertThat(game.getState().usedLetters.contains('a')).isTrue();
    }
    @Test
    public void guessWhenChosenSameLetterWastedAttemptTest() {
        var game = getGameAndSetInputToGuess("a");
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        Console.setStream(in);
        game.guess();
        assertThat(game.getRemainingAttemptsCount()).isEqualTo(8);
    }
    @Test
    public void guessWhenChosenRightLetterNotChangeAttempt() {
        var game = getGameAndSetInputToGuess("a");
        assertThat(game.getRemainingAttemptsCount()).isEqualTo(9);
    }

    @Test
    public void guessCorrectAttemptsCountTest() {
        var game = getGameAndSetInputToGuess("a");
        for (var i = 0; i < 9; i++) {
            setInputToGuess("z", game);
        }
        assertThat(game.isGameEnd()).isTrue();
    }

}
