package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(2, 2)),
            Arguments.of(new Square(2))
        };
    }
    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        assertThat(rect.area()).isEqualTo(4.0);
    }
    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleAreaWithChangeParameters(Rectangle rect) {
        assertThat(rect.setWidth(20).setHeight(10).area()).isEqualTo(200.0);
    }
}
