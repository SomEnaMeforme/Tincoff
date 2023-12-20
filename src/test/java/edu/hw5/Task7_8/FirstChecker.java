package edu.hw5.Task7_8;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw5.Task7_8.BinaryAlphabetChecker.checkMessageContainsAtLeastThreeSymbolAndThirdIsZero;
public class FirstChecker {
    @Test
    public void checkMessageCorrectTest() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("11000")).isEqualTo(true);
    }
    @Test
    public void checkMessageThirdSymbolNotEqualZero() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("11100")).isEqualTo(false);
    }
    @Test
    public void checkMessageLengthLessThanThree() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("11")).isEqualTo(false);
    }
    @Test
    public void checkMessageLengthEqualThree() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("110")).isEqualTo(true);
    }
    @Test
    public void messageIsNull() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero(null)).isEqualTo(false);
    }
    @Test
    public void messageIsEmpty() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("")).isEqualTo(false);
    }
    @Test
    public void otherSymbols() {
        assertThat(checkMessageContainsAtLeastThreeSymbolAndThirdIsZero("45rggd")).isEqualTo(false);
    }
}
