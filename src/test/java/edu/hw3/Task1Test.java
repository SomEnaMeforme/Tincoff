package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.Atbash.atbash;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    void isWorkCorrectTest1() {
        assertThat(atbash("Hello world!")).isEqualTo("Svool dliow!");
    }
    @Test
    void isWorkCorrectTest2() {
        assertThat(atbash("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"))
            .isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
    }
    @Test
    void atbashNotChangeSymbolsNotFromLatinAlphabet() {
        assertThat(atbash("!!ваорап0430"))
            .isEqualTo("!!ваорап0430");
    }
    @Test
    void atbashChangeUpperCaseLetters() {
        assertThat(atbash("AANGAHG"))
            .isEqualTo("ZZMTZST");
    }
    @Test
    void atbashFailsWhenArgumentIsNull() {
        assertThrows(NullPointerException.class, () -> atbash(null));
    }
    @Test
    void atbashNotFailsWhenArgumentIsEmpty() {
        assertThat(atbash("")).isEqualTo("");
    }
}
