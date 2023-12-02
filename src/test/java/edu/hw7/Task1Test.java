package edu.hw7;

import edu.hw7.Task1.Counter;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    public void isAlwaysWorkCorrect() {
        for (var i = 0; i < 10000; i++) {
            var counter = new Counter();
            assertThat(counter.startCount().get()).isEqualTo(0);
        }
    }
    @Test
    public void isAlwaysWorkCorrectWhenHasOneMoreThread() {
        for (var i = 0; i < 10000; i++) {
            var counter = new Counter();
            var thr = new Thread(() -> {
                for (var j = 0; j < 10000; j++) {
                    counter.decrement();
                }
            });
            thr.start();
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            assertThat(counter.startCount().get()).isEqualTo(-10000);
        }
    }
}
