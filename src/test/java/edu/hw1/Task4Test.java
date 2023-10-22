package edu.hw1;


import edu.hw1.task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task4Test {
    @Test
    @DisplayName("Тест на проверку работы метода")
    void isWorkCorrectTest1() {
        //given
        var brokenStr = "оПомигети псаривьтс ртко!и";
        //when
        var result = Task4.fixString(brokenStr);
        //then
        assertThat(result).isEqualTo("Помогите исправить строки!");
    }

    @Test
    @DisplayName("Тест на проверку работы метода")
    void isWorkCorrectTest2() {
        //given
        var brokenStr = "hTsii  s aimex dpus rtni.g";
        //when
        var result = Task4.fixString(brokenStr);
        //then
        assertThat(result).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Тест на проверку работы  с нечётной длиной строки")
    void isWorkCorrectWithOddLengthTest() {
        //given
        var brokenStr = "badce";
        //when
        var result = Task4.fixString(brokenStr);
        //then
        assertThat(result).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Тест с пустой ссылкой в переданном значении")
    void stringIsNullTest() {
        assertThrows(NullPointerException.class, () -> Task4.fixString(null));
    }
    @Test
    @DisplayName("Тест с пустой строкой в переданном значении")
    void stringIsEmptyTest() {
        //given
        var brokenStr = "";
        //when
        var result = Task4.fixString(brokenStr);
        //then
        assertThat(result).isEqualTo("");
    }

    @Test
    @DisplayName("Тест с самой короткой строкой")
    void oneSymbolStringTest() {
        //given
        var brokenStr = "a";
        //when
        var result = Task4.fixString(brokenStr);
        //then
        assertThat(result).isEqualTo("a");
    }

}
