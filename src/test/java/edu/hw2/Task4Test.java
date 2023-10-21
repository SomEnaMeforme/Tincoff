package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.Test;
import edu.hw2.Task4.Task4;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void isWorkCorrectTest() {
        var result = Task4.callingInfo();
        assertThat(result.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(result.methodName()).isEqualTo("isWorkCorrectTest");
    }

    @Test
    void isWorkCorrectAfterCallAnotherFuncTest() {
        var anotherObj = new edu.hw2.Task1.Expr.Addition(1, 2);
        var result = Task4.callingInfo();
        assertThat(result.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(result.methodName()).isEqualTo("isWorkCorrectAfterCallAnotherFuncTest");
    }

    @Test
    void isWorkCorrectWhenCallFromAnotherFuncTest() {
        var result = testingFunc();
        assertThat(result.className()).isEqualTo("edu.hw2.Task4Test");
        assertThat(result.methodName()).isEqualTo("testingFunc");
    }

    private CallingInfo testingFunc() {
        return Task4.callingInfo();
    }
}
