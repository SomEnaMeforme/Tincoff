package edu.hw2.Task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private final Random rnd = new Random();

    @Override
    public Connection getConnection() {
        var connection = rnd.nextBoolean() || rnd.nextBoolean() ? new StableConnection() : new FaultyConnection();
        CONNECTIONS_POOL.add(connection);
        return connection;
    }

}
