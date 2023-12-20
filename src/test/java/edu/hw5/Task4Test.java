package edu.hw5;

import org.junit.jupiter.api.Test;
import static edu.hw5.Task4.SafePasswordCheck.checkPassword;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    public void isCorrectWorkCorrectPassword() {
        assertThat(checkPassword("dftyrWGyg#jhfsd")).isEqualTo(true);
    }
    @Test
    public void isCorrectWorkWrongPassword() {
        assertThat(checkPassword("fsjkghghg")).isEqualTo(false);
    }
    @Test
    public void isCorrectWorkPasswordWhenManyNecessarySymbols() {
        assertThat(checkPassword("dfg$hfdh213g%dfh^")).isEqualTo(true);
    }
    @Test
    public void passwordIsNullTest() {
        assertThat(checkPassword(null)).isEqualTo(false);
    }
    @Test
    public void passwordIsEmptyTest() {
        assertThat(checkPassword("")).isEqualTo(false);
    }
    @Test
    public void passwordIsNecessarySymbolTest() {
        assertThat(checkPassword("#")).isEqualTo(true);
    }
    @Test
    public void passwordIsNecessarySymbolsTest() {
        assertThat(checkPassword("~^&*!@#$%|")).isEqualTo(true);
    }
}
