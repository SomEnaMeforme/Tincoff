package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {

    public BackwardIterator(List<T> list) {
        this.list = list;
    }

    private int current = 0;
    private final List<T> list;

    @Override
    public boolean hasNext() {
        return list.size() - current > 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        var value = list.get(list.size() - current - 1);
        current += 1;
        return value;
    }
}
