package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task5.RussianRegistrationPlates.checkPlate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task5Test {
    @Test
    public void correctPlate1Test() {
        assertThat(checkPlate("А123ВЕ777")).isEqualTo(true);
    }
    @Test
    public void correctPlate2Test() {
        assertThat(checkPlate("О777ОО177")).isEqualTo(true);
    }
    @Test
    public void tooManyLettersTest() {
        assertThat(checkPlate("А123ВЕЕ777")).isEqualTo(false);
    }
    @Test
    public void wrongLetterTest() {
        assertThat(checkPlate("А123ВГ77")).isEqualTo(false);
    }
    @Test
    public void tooManyDigitsTest() {
        assertThat(checkPlate("А123ВЕ7777")).isEqualTo(false);
    }
    @Test
    public void tooManyDigitsTest2() {
        assertThat(checkPlate("А1223ВЕ777")).isEqualTo(false);
    }
    @Test
    public void plateIsNullTest() {
        assertThat(checkPlate(null)).isEqualTo(false);
    }
    @Test
    public void plateIsEmptyTest() {
        assertThat(checkPlate("")).isEqualTo(false);
    }
    @Test
    public void tooFewDigitsTest() {
        assertThat(checkPlate("А123ВЕ77")).isEqualTo(false);
    }
    @Test
    public void tooFewDigits2Test() {
        assertThat(checkPlate("А12ВЕ777")).isEqualTo(false);
    }
    @Test
    public void latinLettersTest() {
        assertThat(checkPlate("A123BE777")).isEqualTo(false);
    }
}
