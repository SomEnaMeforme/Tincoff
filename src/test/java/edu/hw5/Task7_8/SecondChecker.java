package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageStartEqualToEnd;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SecondChecker {
    @Test
    public void checkMessageCorrectTest() {
        assertThat(checkMessageStartEqualToEnd("110001")).isEqualTo(true);
    }
    @Test
    public void checkMessageCorrectTest2() {
        assertThat(checkMessageStartEqualToEnd("01110")).isEqualTo(true);
    }
    @Test
    public void checkMessageOneSymbol() {
        assertThat(checkMessageStartEqualToEnd("1")).isEqualTo(true);
    }
    @Test
    public void checkMessageTwoSymbols() {
        assertThat(checkMessageStartEqualToEnd("00")).isEqualTo(true);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageStartEqualToEnd(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageStartEqualToEnd("")).isEqualTo(false);
    }
    @Test
    public void otherSymbols() {
        assertThat(checkMessageStartEqualToEnd("045rggd")).isEqualTo(false);
    }
    @Test
    public void otherSymbolsWithEqualStartAndEnd() {
        assertThat(checkMessageStartEqualToEnd("045rggd0")).isEqualTo(false);
    }
}
