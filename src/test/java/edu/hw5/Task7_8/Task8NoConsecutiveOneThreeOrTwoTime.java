package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageNoConsecutiveOneTwoOrThreeTime;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8NoConsecutiveOneThreeOrTwoTime {


    @Test
    public void messageIsCorrect() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("1001010100")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectConsecutiveZero() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("0101001")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectWithTwoConsecutiveOne() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("11")).isEqualTo(false);
    }
    @Test
    public void messageWrongWithThreeConsecutiveOne() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("111")).isEqualTo(false);
    }
    @Test
    public void messageWrongWithThreeConsecutiveOneAndZero() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("10011101011100")).isEqualTo(true);
    }
    @Test
    public void messageHasOtherSymbols() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("1001gfh10101100")).isEqualTo(false);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageNoConsecutiveOneTwoOrThreeTime("")).isEqualTo(false);
    }
}

