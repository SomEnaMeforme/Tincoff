package edu.hw2.Task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String s, Exception e) {
        super(s, e);
    }
    public ConnectionException() {
        super();
    }
}
