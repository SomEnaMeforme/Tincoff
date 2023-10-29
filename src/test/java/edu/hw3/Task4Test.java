package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task4.RomanConverter.convertToRoman;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task4Test {

    @Test
    public void isWorkCorrectWithSimpleNumberTest() {
        assertThat(convertToRoman(12)).isEqualTo("XII");
    }
    @Test
    public void isWorkCorrectWithOneDigitMoreThanFiveNumberTest() {
        assertThat(convertToRoman(7)).isEqualTo("VII");
    }
    @Test
    public void isWorkCorrectWithOneDigitLessThanFiveNumberTest() {
        assertThat(convertToRoman(4)).isEqualTo("IV");
    }
    @Test
    public void isWorkCorrectWithNineTest() {
        assertThat(convertToRoman(9)).isEqualTo("IX");
    }

    @Test
    public void isWorkCorrectWithComplicateNumberTest() {
        assertThat(convertToRoman(3479)).isEqualTo("MMMCDLXXIX");
    }
    @Test
    public void isWorkCorrectWithSameDigitsTest() {
        assertThat(convertToRoman(333)).isEqualTo("CCCXXXIII");
    }
    @Test
    public void returnMessageWhenInputNorCorrectTest() {
        assertThat(convertToRoman(0)).isEqualTo("Invalid input");
    }
}
