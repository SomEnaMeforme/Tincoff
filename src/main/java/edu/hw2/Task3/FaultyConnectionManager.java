package edu.hw2.Task3;

import java.util.ArrayList;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        var connection = new FaultyConnection();
        connectionsPool.add(connection);
        return connection;
    }
}
