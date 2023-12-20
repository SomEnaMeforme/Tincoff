package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageLengthAtLeastOneNoMoreThanThree;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class ThirdChecker {
    @Test
    public void messageCorrectTest() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("110")).isEqualTo(true);
    }
    @Test
    public void messageCorrectTest2() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("101")).isEqualTo(true);
    }
    @Test
    public void messageLengthEqualTwoTest() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("11")).isEqualTo(true);
    }
    @Test
    public void messageLengthEqualOneTest() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("1")).isEqualTo(true);
    }
    @Test
    public void messageLengthMoreThanThree() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("0101")).isEqualTo(false);
    }
    @Test
    public void messageHasCorrectLengthWithOtherSymbols() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("0f1")).isEqualTo(false);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageLengthAtLeastOneNoMoreThanThree("")).isEqualTo(false);
    }
}
