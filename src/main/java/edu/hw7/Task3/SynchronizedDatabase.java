package edu.hw7.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedDatabase implements PersonDatabase {
    private final Map<String, List<Person>> byName = new HashMap<>();
    private final Map<String, List<Person>> byAddress = new HashMap<>();
    private final Map<String, List<Person>> byPhone = new HashMap<>();
    private final Map<Integer, Person> byID = new HashMap<>();

    @Override
    public synchronized void add(Person person) {
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
    }

    @Override
    public synchronized void delete(int id) {
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
    }

    @Override
    public synchronized List<Person> findByName(String name) {
        if (byName.containsKey(name)) {
            var person = byName.get(name).get(0);
            if (byAddress.get(person.address()) == null || byPhone.get(person.phoneNumber()) == null) {
                return null;
            }
            return byName.get(name);
        }
        return null;
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        if (byAddress.containsKey(address)) {
            var person = byAddress.get(address).get(0);
            if (byName.get(person.name()) == null || byPhone.get(person.phoneNumber()) == null) {
                return null;
            }
            return byAddress.get(address);
        }
        return null;
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        if (byPhone.containsKey(phone)) {
            var person = byPhone.get(phone).get(0);
            if (byName.get(person.name()) == null || byName.get(person.name()) == null) {
                return null;
            }
            return byPhone.get(phone);
        }
        return null;
    }
}
