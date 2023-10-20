package edu.hw2.Task3Test;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConnectionTest {
    @Test
    void StableConnectionNeverFailTest() {
        try {

            var connection = new StableConnection();
            for (var i = 0; i < 100; i++) {
                connection.execute("commit changes");
            }
        }
        catch (Exception e) {
            assertThat(0).isEqualTo(1);
        }
    }
    @Test
    void FaultyConnectionFailTest() {
        var connection = new StableConnection();
    }
}
