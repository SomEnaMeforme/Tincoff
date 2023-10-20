package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class FaultyConnection implements Connection{
    private final Random rnd = new Random();
    private final static Logger LOGGER = LogManager.getLogger();
    @Override
    public void execute(String command) throws ConnectionException {
        if (isFail()) {
            LOGGER.info("Faulty connection return exception");
            throw new ConnectionException();
        }
        LOGGER.info(String.format("Execute command %s with faulty connection", command));
    }

    @Override
    public void close() throws Exception {
        ConnectionManager.connectionsPool.remove(this);
        LOGGER.info("Faulty connection was closed");
    }

    private boolean isFail() {
        return rnd.nextInt(100) > 70;
    }
}
