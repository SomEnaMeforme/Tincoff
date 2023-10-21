package edu.hw2.Task3Test;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PopularCommandExecutorTest {
    @Test
    void PopularExecutorMayReturnFailsTest() {
        var executor = new PopularCommandExecutor(3, new DefaultConnectionManager());
        assertThrows(ConnectionException.class, () -> {
            for (var i = 0; i < 10; i++) {
                executor.updatePackages();
            }
        });
    }

    @Test
    void PopularExecutorCallConnectionCloseTest() {
        var executor = new PopularCommandExecutor(3, new DefaultConnectionManager());
        var poolCount = ConnectionManager.CONNECTIONS_POOL.stream().count();
        try {
            executor.updatePackages();
        } catch (ConnectionException e) {
        } finally {
            assertThat(ConnectionManager.CONNECTIONS_POOL.stream().count()).isEqualTo(poolCount);
        }
    }
}
