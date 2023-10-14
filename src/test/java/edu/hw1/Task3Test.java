package edu.hw1;

import edu.hw1.task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task3Test {
    @Test
    @DisplayName("Тест с переданными пустыми множествами")
    void emptyArraysTest() {
        //given
        var emptyArray = new int[0];
        var notEmptyArray = new int[] {1, 2};
        //when
        var result1 = Task3.isNestable(emptyArray, emptyArray);
        var result2 = Task3.isNestable(emptyArray, notEmptyArray);
        var result3 = Task3.isNestable(notEmptyArray, emptyArray);
        //then
        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();

    }

    @Test
    @DisplayName("Тест с двумя переданными null")
    void nullArraysTest() {
        assertThrows(NullPointerException.class, () -> Task3.isNestable(null, null));
    }
    @Test
    @DisplayName("Тест с переданным null в качестве первого аргумента")
    void firstNullArrayTest() {
        assertThrows(NullPointerException.class, () -> Task3.isNestable(null, new int[] {1, 2, 33}));
    }
    @Test
    @DisplayName("Тест с переданным null в качестве второго аргумента")
    void secondNullArrayTest() {
        assertThrows(NullPointerException.class, () -> Task3.isNestable(new int[] {1, 2, 33}, null));
    }
    @Test
    @DisplayName("Массивы можно вложить")
    void isWorkCorrectTest1() {
        //given
        int[] first = new int[] {4, 5, 6, 7};
        int[] second = new int[] {3, 6, 8};
        //when
        var result = Task3.isNestable(first, second);
        //then
        assertThat(result).isTrue();
    }
    @Test
    @DisplayName("Массивы нельзя вложить")
    void isWorkCorrectTest2() {
        //given
        int[] first = new int[] {4, 5, 6, 9};
        int[] second = new int[] {3, 6, 8};
        //when
        var result = Task3.isNestable(first, second);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Массивы нельзя вложить, минимумы равны")
    void isWorkCorrectTest3() {
        //given
        int[] first = new int[] {3, 5, 6, 9};
        int[] second = new int[] {3, 6, 10};
        //when
        var result = Task3.isNestable(first, second);
        //then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Массивы нельзя вложить, максимумы равны")
    void isWorkCorrectTest4() {
        //given
        int[] first = new int[] {4, 5, 6, 10};
        int[] second = new int[] {3, 6, 10};
        //when
        var result = Task3.isNestable(first, second);
        //then
        assertThat(result).isFalse();
    }


}
