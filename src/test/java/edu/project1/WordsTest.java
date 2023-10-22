package edu.project1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Arrays;

public class WordsTest {
    @Test
    public void randomWordReturnWordFromDictionaryTest() {
        var word = Words.getRandomWord();
        assertThat(Arrays.asList(Words.DICTIONARY).contains(word)).isTrue();
    }
    @Test
    public void dictionaryContainsWordsTest() {
        assertThat(Arrays.stream(Words.DICTIONARY).findAny().isPresent()).isTrue();
    }
    @Test
    public void dictionaryContainsCorrectWordsTest() {
        assertThat(Arrays.stream(Words.DICTIONARY).allMatch(str -> str.length() > 5 && str.matches("[a-z]+"))).isTrue();
    }
}
