package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageContainsAtLeastTwoZeroAndOnceOne;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8ContainsNecessaryCountOfZeroAndOne {
    @Test
    public void messageIsCorrectOneFirst() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("100")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectOneLast() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("001")).isEqualTo(true);
    }
    @Test
    public void messageIsCorrectOneInMiddle() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("0100")).isEqualTo(true);
    }
    @Test
    public void messageIsWrongTwoOne() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("10100")).isEqualTo(false);
    }
    @Test
    public void messageIsWrongTwoOneNear() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("01100")).isEqualTo(false);
    }
    @Test
    public void messageWithoutOneIsWrong() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("01100")).isEqualTo(false);
    }
    @Test
    public void messageWithOneZeroWrong() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("01")).isEqualTo(false);
    }
    @Test
    public void messageIsNullTest() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageContainsAtLeastTwoZeroAndOnceOne("")).isEqualTo(false);
    }
}
