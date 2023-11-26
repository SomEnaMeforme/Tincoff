package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.PersonDatabase;
import edu.hw7.Task3.ReadAndWriteDatabase;
import edu.hw7.Task3.SynchronizedDatabase;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private AssertionError exc = null;

    public ArrayList<Thread> getThreadsForTest(Person[] persons, PersonDatabase db) {
        var list = new ArrayList<Thread>();
        for (var person : persons) {
            db.add(person);
            var findByNameThread = new Thread(() -> {
                if (db.findByName(person.name()) == null) {
                    assertThat(exc == null).isTrue();
                    throw new RuntimeException();
                }
            });
            var findByAddressThread = new Thread(() -> {
                if (db.findByAddress(person.address()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            var findByPhoneThread = new Thread(() ->
            {
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            list.add(findByNameThread);
            list.add(findByAddressThread);
            list.add(findByPhoneThread);
        }
        return list;

    }

    @Test
    public void addAndParallelFindPerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new SynchronizedDatabase();
        for (var i = 0; i < 1000; i++) {
            var addThread = new Thread(() -> db.add(person));
            var findByNameThread = new Thread(() -> {
                if (db.findByName(person.name()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            var findByAddressThread = new Thread(() -> {
                db.findByPhone(person.phoneNumber());
                if (db.findByAddress(person.address()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            var findByPhoneThread = new Thread(() ->
            {
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });

            addThread.start();
            findByAddressThread.start();
            findByNameThread.start();
            findByPhoneThread.start();
            try {
                addThread.join();
                findByAddressThread.join();
                findByNameThread.join();
                findByPhoneThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void findSimultaneouslyPerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new SynchronizedDatabase();
        db.add(person);
        for (var i = 0; i < 1000; i++) {
            var findSimultaneouslyThread = new Thread(() -> {
                if (db.findByName(person.name()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
                if (db.findByAddress(person.address()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });

            findSimultaneouslyThread.start();
            try {
                findSimultaneouslyThread.join();
            } catch (InterruptedException e) {
                exc = new AssertionError();
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void simultaneouslyAddAndDeletePerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new SynchronizedDatabase();
        for (var i = 0; i < 1000; i++) {
            var addThread = new Thread(() -> db.add(person));
            var deleteThread = new Thread(() -> {
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                }
                db.delete(person.id());
            });
            var addThread2 = new Thread(() -> db.add(person));

            addThread.start();
            deleteThread.start();
            try {
                addThread2.start();
                deleteThread.join();
                addThread.join();
                addThread2.join();
            } catch (InterruptedException e) {
                exc = new AssertionError();
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void manyPersonsAddAndFind() {
        var persons = new Person[] {
            new Person(1, "Masha", "Broadway", "94365"),
            new Person(2, "Bla", "Brod", "76435"),
            new Person(3, "Greg", "West", "765655"),
            new Person(4, "Blob", "Candy_Street", "09543"),
            new Person(5, "Mary", "Marks", "23443"),
            new Person(6, "Sora", "North", "9080789"),
        };
        var db = new SynchronizedDatabase();
        for (var i = 0; i < 1000; i++) {
            var threads = getThreadsForTest(persons, db);

            for (var thread : threads) {
                thread.start();
            }
            try {
                for (var thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                exc = new AssertionError();
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }
    @Test
    public void lockAddAndParallelFindPerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new ReadAndWriteDatabase();
        for (var i = 0; i < 1000; i++) {
            var addThread = new Thread(() -> db.add(person));
            var findByNameThread = new Thread(() -> {
                if (db.findByName(person.name()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            var findByAddressThread = new Thread(() -> {
                db.findByPhone(person.phoneNumber());
                if (db.findByAddress(person.address()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });
            var findByPhoneThread = new Thread(() ->
            {
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });

            addThread.start();
            findByAddressThread.start();
            findByNameThread.start();
            findByPhoneThread.start();
            try {
                addThread.join();
                findByAddressThread.join();
                findByNameThread.join();
                findByPhoneThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void lockFindSimultaneouslyPerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new ReadAndWriteDatabase();
        db.add(person);
        for (var i = 0; i < 1000; i++) {
            var findSimultaneouslyThread = new Thread(() -> {
                if (db.findByName(person.name()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
                if (db.findByAddress(person.address()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                    throw new RuntimeException();
                }
            });

            findSimultaneouslyThread.start();
            try {
                findSimultaneouslyThread.join();
            } catch (InterruptedException e) {
                exc = new AssertionError();
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void lockSimultaneouslyAddAndDeletePerson() {
        var person = new Person(1, "Masha", "Broadway", "94365");
        var db = new ReadAndWriteDatabase();
        for (var i = 0; i < 1000; i++) {
            var addThread = new Thread(() -> db.add(person));
            var deleteThread = new Thread(() -> {
                if (db.findByPhone(person.phoneNumber()) == null) {
                    exc = new AssertionError();
                }
                db.delete(person.id());
            });
            var addThread2 = new Thread(() -> db.add(person));

            addThread.start();
            deleteThread.start();
            try {
                addThread2.start();
                deleteThread.join();
                addThread.join();
                addThread2.join();
            } catch (InterruptedException e) {
                exc = new AssertionError();
            }
        }
        assertThat(exc == null).isTrue();
    }

    @Test
    public void lockManyPersonsAddAndFind() {
        var persons = new Person[] {
            new Person(1, "Masha", "Broadway", "94365"),
            new Person(2, "Bla", "Brod", "76435"),
            new Person(3, "Greg", "West", "765655"),
            new Person(4, "Blob", "Candy_Street", "09543"),
            new Person(5, "Mary", "Marks", "23443"),
            new Person(6, "Sora", "North", "9080789"),
        };
        var db = new ReadAndWriteDatabase();
        for (var i = 0; i < 1000; i++) {
            var threads = getThreadsForTest(persons, db);

            for (var thread : threads) {
                thread.start();
            }
            try {
                for (var thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                exc = new AssertionError();
                throw new RuntimeException(e);
            }
        }
        assertThat(exc == null).isTrue();
    }
}
