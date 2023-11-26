package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteDatabase implements PersonDatabase {
    private final Map<String, List<Person>> byName = new HashMap<>();
    private final Map<String, List<Person>> byAddress = new HashMap<>();
    private final Map<String, List<Person>> byPhone = new HashMap<>();
    private final Map<Integer, Person> byID = new HashMap<>();
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    @Override
    public void add(Person person) {
        writeLock.lock();
        try {
            byID.put(person.id(), person);
            if (!byName.containsKey(person.name())) {
                byName.put(person.name(), new ArrayList<>());
            }
            if (!byAddress.containsKey(person.address())) {
                byAddress.put(person.address(), new ArrayList<>());
            }
            if (!byPhone.containsKey(person.phoneNumber())) {
                byPhone.put(person.phoneNumber(), new ArrayList<>());
            }
            byName.get(person.name()).add(person);
            byAddress.get(person.address()).add(person);
            byPhone.get(person.phoneNumber()).add(person);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void delete(int id) {
        writeLock.lock();
        try {
            if (byID.containsKey(id)) {
                var person = byID.get(id);
                if (byName.containsKey(person.name())) {
                    byName.get(person.name()).remove(person);
                }
                if (byAddress.containsKey(person.address())) {
                    byAddress.get(person.address()).remove(person);
                }
                if (byPhone.containsKey(person.phoneNumber())) {
                    byPhone.get(person.phoneNumber()).remove(person);
                }
            }
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        readLock.lock();
        List<Person> persons = null;
        try {
            if (byName.containsKey(name)) {
                persons = byName.get(name);
                var person = persons.get(0);
                if (byAddress.get(person.address()) == null || byPhone.get(person.phoneNumber()) == null) {
                    return null;
                }
            }
        } finally {
            readLock.unlock();
        }
        return persons;
    }

    @Override
    public List<Person> findByAddress(String address) {
        readLock.lock();
        List<Person> persons = null;
        try {
            if (byAddress.containsKey(address)) {
                persons = byAddress.get(address);
                var person = persons.get(0);
                if (byName.get(person.name()) == null || byPhone.get(person.phoneNumber()) == null) {
                    return null;
                }
            }
        } finally {
            readLock.unlock();
        }
        return persons;
    }

    @Override
    public List<Person> findByPhone(String phone) {
        readLock.lock();
        List<Person> persons = null;
        try {
            if (byPhone.containsKey(phone)) {
                persons = byPhone.get(phone);
                var person = persons.get(0);
                if (byName.get(person.name()) == null || byName.get(person.name()) == null) {
                    return null;
                }
            }
        } finally {
            readLock.unlock();
        }
        return persons;
    }
}
