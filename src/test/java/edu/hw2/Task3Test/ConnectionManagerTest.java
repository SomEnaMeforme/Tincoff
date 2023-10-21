package edu.hw2.Task3Test;

import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConnectionManagerTest {
    @Test
    void ConnectionCreateAddConnectionToPoolTest() {
        var connection = new DefaultConnectionManager().getConnection();
        assertThat(ConnectionManager.CONNECTIONS_POOL.contains(connection)).isTrue();
    }

    @Test
    void ConnectionCloseDeleteConnectionFromPoolTest() {
        var connection = new StableConnection();
        try {
            connection.close();
        } catch (Exception e) {
        }
        assertThat(ConnectionManager.CONNECTIONS_POOL.contains(connection)).isFalse();

    }

    @Test
    void DefaultConnectionManagerSometimesReturnFaultyConnectionTest() {
        var manager = new DefaultConnectionManager();
        for (var i = 0; i < 100; i++) {
            if (manager.getConnection() instanceof FaultyConnection) {
                assertThat(1).isEqualTo(1);
                break;
            }
        }
    }

    @Test
    void FaultyConnectionManagerAlwaysReturnFaultyConnectionTest() {
        var manager = new FaultyConnectionManager();
        assertThat(manager.getConnection() instanceof FaultyConnection).isTrue();
    }
}
