package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import edu.hw1.task8.Task8;

public class Task8Test {
    @Test
    @DisplayName("Проверка на корректность работы метода 1")
    public void isWorkCorrectTest1() {
        //given
        var board = new int[][] {
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 1, 0, 0, 0, 0, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0}
        };
        //when

        //then
        assertThat(Task8.knightBoardCapture(board)).isTrue();
    }

    @Test
    @DisplayName("Проверка на корректность работы метода 2")
    public void isWorkCorrectTest2() {
        //given
        var board = new int[][] {
            new int[] {1, 0, 1, 0, 1, 0, 1, 0},
            new int[] {0, 1, 0, 1, 0, 1, 0, 1},
            new int[] {0, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 1, 0, 0, 1, 0, 1},
            new int[] {1, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 1},
            new int[] {1, 0, 0, 0, 1, 0, 1, 0},
            new int[] {0, 0, 0, 1, 0, 1, 0, 1}
        };
        //when

        //then
        assertThat(Task8.knightBoardCapture(board)).isFalse();
    }

    @Test
    @DisplayName("Проверка на корректность работы метода 3")
    public void isWorkCorrectTest3() {
        //given
        var board = new int[][] {
            new int[] {0, 0, 0, 0, 1, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 1, 0, 0, 0, 0},
            new int[] {1, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 1, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {0, 0, 0, 0, 0, 1, 0, 0},
            new int[] {1, 0, 0, 0, 0, 0, 0, 0}
        };
        //when

        //then
        assertThat(Task8.knightBoardCapture(board)).isFalse();
    }

    @Test
    @DisplayName("Пустая доска")
    public void boardWithoutKnights() {
        //given
        var board = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0}
        };
        //when

        //then
        assertThat(Task8.knightBoardCapture(board)).isTrue();
    }

    @Test
    @DisplayName("В качестве доски передан null")
    public void rowIsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> Task8.knightBoardCapture(null));
    }

    @Test
    @DisplayName("В качестве одной из строк передан null")
    public void boardIsNullTest() {
        //given
        var board = new int[][] {
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            new int[] {0, 0, 0, 0, 0, 0, 0, 0},
            null,
            new int[] {0, 0, 0, 0, 0, 0, 0, 0}
        };
        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> Task8.knightBoardCapture(board));
    }
}
