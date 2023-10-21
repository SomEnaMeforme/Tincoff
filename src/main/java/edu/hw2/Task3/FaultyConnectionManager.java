package edu.hw2.Task3;

public class FaultyConnectionManager implements ConnectionManager {

    @Override
    public Connection getConnection() {
        var connection = new FaultyConnection();
        CONNECTIONS_POOL.add(connection);
        return connection;
    }
}
