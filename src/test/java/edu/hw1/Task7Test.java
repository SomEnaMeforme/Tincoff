package edu.hw1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw1.task7.Task7;
public class Task7Test {
    @Test
    @DisplayName("Тест на проверку корректности работы 1")
    public void isWorkCorrect1Test(){
        //given
        var number = 8;
        var shift = 1;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(4);
        assertThat(resultLeft).isEqualTo(1);
    }
    @Test
    @DisplayName("Тест на проверку корректности работы 2")
    public void isWorkCorrect2Test(){
        //given
        var number = 17;
        var shift = 2;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(12);
        assertThat(resultLeft).isEqualTo(6);
    }
    @Test
    @DisplayName("Тест на проверку корректности работы 3")
    public void isWorkCorrect3Test(){
        //given
        var number = 36;
        var shift = 2;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(9);
        assertThat(resultLeft).isEqualTo(18);
    }
    @Test
    @DisplayName("Сдвиг равен длине двоичного представления")
    public void shiftEqualsToBinaryLengthTest(){
        //given
        var number = 49;
        var shift = 6;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(49);
        assertThat(resultLeft).isEqualTo(49);
    }
    @Test
    @DisplayName("Сдвиг больше длины вдоичного представления числа")
    public void shiftMoreToBinaryLengthTest(){
        //given
        var number = 49;
        var shift = 11;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(35);
        assertThat(resultLeft).isEqualTo(56);
    }
    @Test
    @DisplayName("Тест на проверку корректности работы 5")
    public void numberIsZeroTest(){
        //given
        var number = 0;
        var shift = 11;
        //when
        var resultRight = Task7.rotateRight(number, shift);
        var resultLeft = Task7.rotateLeft(number, shift);
        //then
        assertThat(resultRight).isEqualTo(0);
        assertThat(resultLeft).isEqualTo(0);
    }
}
