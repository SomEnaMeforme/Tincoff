package edu.hw1;


import edu.hw1.task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @ParameterizedTest
    @ValueSource(ints = {11211230, 11, 595, 13001120, 23336014, 5801})
    @DisplayName("Тест на проверку работы метода")
    void isWorkCorrectTest(Integer numb) {
        assertThat(Task5.isPalindromeDescendant(numb)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 7648, 5871, 13})
    @DisplayName("Тест на проверку работы метода")
    void isMethodFailsTest(Integer numb) {
        assertThat(Task5.isPalindromeDescendant(numb)).isFalse();
    }
}
