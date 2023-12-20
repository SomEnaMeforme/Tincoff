package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageHasOddLength;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task8First {
    @Test
    public void messageCorrectTest() {
        assertThat(checkMessageHasOddLength("110")).isEqualTo(true);
    }
    @Test
    public void messageHasOneSymbol() {
        assertThat(checkMessageHasOddLength("1")).isEqualTo(true);
    }
    @Test
    public void messageCorrectLengthWithOtherSymbol() {
        assertThat(checkMessageHasOddLength("1dffg")).isEqualTo(false);
    }
    @Test
    public void messageEvenLength() {
        assertThat(checkMessageHasOddLength("1010")).isEqualTo(false);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageHasOddLength(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageHasOddLength("")).isEqualTo(false);
    }
}
