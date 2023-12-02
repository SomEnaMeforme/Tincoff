package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.Clusterizer.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task2Test {
    @Test
    public void isWorkCorrectWithManySingleBktTest() {
        assertThat(clusterize("()()()").toString()).isEqualTo("[(), (), ()]");
    }
    @Test
    public void isWorkCorrectTestWithManyNestedBkt() {
        assertThat(clusterize("((()))").toString()).isEqualTo("[((()))]");
    }
    @Test
    public void isWorkCorrectTestWithManyNestedAndSingleBkt() {
        assertThat(clusterize("((()))(())()()(()())").toString())
            .isEqualTo("[((())), (()), (), (), (()())]");
    }
    @Test
    public void isWorkCorrectTestWithNotSymmetricalBkt() {
        assertThat(clusterize("((())())(()(()()))").toString())
            .isEqualTo("[((())()), (()(()()))]");
    }
    @Test
    public void isReturnNullWhenStringHaveInCorrectFormat() {
        assertThat(clusterize("((())())(g()(()()))"))
            .isEqualTo(null);
    }
    @Test
    public void isReturnNullWhenStringHaveUnclosedBkt() {
        assertThat(clusterize("((())())(()(()())"))
            .isEqualTo(null);
    }
}
