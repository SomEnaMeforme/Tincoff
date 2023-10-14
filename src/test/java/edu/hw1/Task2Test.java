package edu.hw1;

import edu.hw1.task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @ParameterizedTest
    @ValueSource(ints = {543645655, 0, 59, 10, 9})
    @DisplayName("Тест на проверку работы метода")
    void isWorkCorrectTest(Integer numb) {
        // given

        // when
        var result = Task2.getCountDigits(numb);

        // then
        assertThat(result).isEqualTo(getCorrectDigitsCount(numb));
    }
    @ParameterizedTest
    @ValueSource(ints = {-122345, -1, -10, -9})
    @DisplayName("Тест на роверку работы с отрицательными числами")
    void negativeNumberTest(Integer number) {
        // given

        // when
        var result = Task2.getCountDigits(number);

        // then
        assertThat(result).isEqualTo(getCorrectDigitsCount(number));
    }
    private int getCorrectDigitsCount(Integer numb) {
        var stringNumb = numb.toString();
        return stringNumb.charAt(0) == '-' ? stringNumb.length() - 1 : stringNumb.length();
    }

}
