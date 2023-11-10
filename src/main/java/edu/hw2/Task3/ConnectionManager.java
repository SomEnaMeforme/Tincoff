package edu.hw2.Task3;

import java.util.ArrayList;

public interface ConnectionManager {
    ArrayList<Connection> CONNECTIONS_POOL = new ArrayList<Connection>();

    Connection getConnection();
}
