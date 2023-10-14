package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw1.task0_task1.Task1;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Task1Test {
    @Test
    @DisplayName("Тест на проверку работы метода")
    void minutesToSecondsWorkTest() {
        // given
        var time = "44:59";

        // when
        var result = Task1.minutesToSeconds(time);
        var seconds = 44*60+59;

        // then
        assertThat(result).isEqualTo(seconds);
    }
    @Test
    @DisplayName("Время равно 0")
    void zeroSecondsTest() {
        // given
        var time = "00:00";
        // when
        var result = Task1.minutesToSeconds(time);
        var seconds = 0;
        // then
        assertThat(result).isEqualTo(seconds);
    }

    @Test
    @DisplayName("Тест на большое количество минут во входных данных")
    void longMinutesInTimeTest() {
        // given
        var time = "445235544:53";

        // when
        var result = Task1.minutesToSeconds(time);
        var seconds = 445235544*60+53;

        // then
        assertThat(result).isEqualTo(seconds);
    }
    // given
    @ParameterizedTest
    @ValueSource(strings = {"-1:56", "4:86", "dfsf", "7653", "00:60", "gh:09", "45:45:55"})
    @DisplayName("Тест на обработку неккоректного ввода")
    void invalidInputTest(String time) {
        // given

        // when
        var result = Task1.minutesToSeconds(time);

        // then
        assertThat(result).isEqualTo(1);
    }

}
