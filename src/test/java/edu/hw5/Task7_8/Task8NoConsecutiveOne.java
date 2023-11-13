package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageNoConsecutiveOne;

public class Task8NoConsecutiveOne {
    @Test
    public void messageIsCorrect() {
        assertThat(checkMessageNoConsecutiveOne("1001010100")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectConsecutiveZero() {
        assertThat(checkMessageNoConsecutiveOne("0101001")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectWithTwoConsecutiveOne() {
        assertThat(checkMessageNoConsecutiveOne("100110101100")).isEqualTo(false);
    }
    @Test
    public void messageWrongWithThreeConsecutiveOne() {
        assertThat(checkMessageNoConsecutiveOne("1001101011100")).isEqualTo(false);
    }
    @Test
    public void messageHasOtherSymbols() {
        assertThat(checkMessageNoConsecutiveOne("1001gfh10101100")).isEqualTo(false);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageNoConsecutiveOne(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageNoConsecutiveOne("")).isEqualTo(false);
    }
}
