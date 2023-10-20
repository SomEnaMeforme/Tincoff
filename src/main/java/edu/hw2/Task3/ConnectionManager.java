package edu.hw2.Task3;

import java.util.ArrayList;

public interface ConnectionManager {
    public static final ArrayList<Connection> connectionsPool = new ArrayList<Connection>();

    Connection getConnection();
}
