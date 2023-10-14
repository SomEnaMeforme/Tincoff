package edu.hw1;

import edu.hw1.task6.Task6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class Task6Test {
    @Test
    @DisplayName("Тест на проверку корректности работы 1")
    public void isWorkCorrect1Test(){
        //given
        var number = 6621;
        //when
        var result = Task6.countK(number);
        //then
        assertThat(result).isEqualTo(5);
    }
    @Test
    @DisplayName("Тест на проверку корректности работы 2")
    public void isWorkCorrect2Test(){
        //given
        var number = 6554;
        //when
        var result = Task6.countK(number);
        //then
        assertThat(result).isEqualTo(4);
    }
    @Test
    @DisplayName("Тест на проверку корректности работы 3")
    public void isWorkCorrect3Test(){
        //given
        var number = 1234;
        //when
        var result = Task6.countK(number);
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест с входным значением, равным постоянной Капрекара")
    public void numberIsKaprekarConstantTest(){
        //given
        var number = 6174;
        //when
        var result = Task6.countK(number);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Тест с числом меньшим 1000")
    public void numberLessThanThousandTest() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(174));
    }
    @Test
    @DisplayName("Тест с числом равным 1000")
    public void numberEqualsThousandTest() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(174));
    }
    @Test
    @DisplayName("Тест с равными цифрами")
    public void evenNumberWithSameDigitsTest(){
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(7777));
    }
    @Test
    @DisplayName("Тест с равными цифрами")
    public void oddNumberWithSameDigitsTest(){
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(777));
    }
    @Test
    @DisplayName("Тест с длинным числом")
    public void longNumberTest(){
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(717867));
    }
}
