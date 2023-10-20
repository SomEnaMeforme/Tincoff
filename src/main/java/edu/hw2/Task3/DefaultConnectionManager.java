package edu.hw2.Task3;

import java.util.ArrayList;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {

    private final Random rnd = new Random();

    @Override
    public Connection getConnection() {
        var connection = rnd.nextInt(10) > 4 ? new StableConnection() : new FaultyConnection();
        connectionsPool.add(connection);
        return connection;
    }

}
