package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static edu.hw2.Task1.Expr.Constant;
import static edu.hw2.Task1.Expr.Addition;
import static edu.hw2.Task1.Expr.Exponent;
import static edu.hw2.Task1.Expr.Multiplication;
import static edu.hw2.Task1.Expr.Negate;

public class Task1Test {
    @Test
    @DisplayName("Для положительных входных значений, Negate возвращает отрицательное значение")
    void negateFromPositiveConstReturnNegativeTest() {
        var positiveConst = new Constant(4.5);
        var negative = new Negate(positiveConst);
        assertThat(negative.evaluate()).isEqualTo(-4.5);
    }

    @Test
    @DisplayName("Для отрицательных входных значений Negate возвращает отрицательное значение")
    void negateFromNegativeConstReturnNegativeTest() {
        var negativeConst = new Constant(-4.5);
        var negative = new Negate(negativeConst);
        assertThat(negative.evaluate()).isEqualTo(-4.5);
    }

    @Test
    @DisplayName("Negate работает и для переданных на вход double")
    void inputToNegateMayBeDoubleTest() {
        var negative = new Negate(64.8);
        assertThat(negative.evaluate()).isEqualTo(-64.8);
    }

    @Test
    @DisplayName("Тестирование входных значений для Multiplication")
    void inputToMultiplicationTest() {
        assertThat(new Multiplication(4, 0.8).evaluate()).isEqualTo(3.2);
        assertThat(new Multiplication(new Constant(4), 0.8).evaluate()).isEqualTo(3.2);
        assertThat(new Multiplication(4, new Constant(0.8)).evaluate()).isEqualTo(3.2);
    }

    @Test
    @DisplayName("Тестирование входных значений для Addition")
    void inputToAdditionTest() {
        assertThat(new Addition(4, 0.8).evaluate()).isEqualTo(4.8);
        assertThat(new Addition(new Constant(4), 0.8).evaluate()).isEqualTo(4.8);
        assertThat(new Addition(4, new Constant(0.8)).evaluate()).isEqualTo(4.8);
    }

    @Test
    @DisplayName("Тестирование входных значений для Addition")
    void inputToExponentTest() {
        assertThat(new Exponent(4, 1.5).evaluate()).isEqualTo(8);
        assertThat(new Exponent(new Constant(4), 1.5).evaluate()).isEqualTo(8);
        assertThat(new Exponent(4, new Constant(1.5)).evaluate()).isEqualTo(8);
    }

    @Test
    @DisplayName("Тестирование входных значений для Addition")
    void complicatedCorrectWorkTest() {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));
        assertThat(res.evaluate()).isEqualTo(37);
    }

}
