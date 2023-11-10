package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private final static Logger LOGGER = LogManager.getLogger();

    public PopularCommandExecutor(int maxAttempts, ConnectionManager manager) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Exception cause = null;
        for (var i = 0; i < maxAttempts; i++) {
            try (var connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (Exception e) {
                LOGGER.info("Faulty connection return when you try execute command exception");
                if (i + 1 == maxAttempts) {
                    cause = e;
                }
            }
        }
        if (cause != null) {
            throw new ConnectionException("The command sent could not be executed", cause);
        }
    }
}
