package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.TreeSet;

public class ContactsParser {
    private ContactsParser() {
    }

    public enum ParseMode {
        ASC,
        DESC
    }

    private static int comparator(FullName o1, FullName o2) {
        if (o1.surname() == null && o2.surname() == null) {
            return o1.name().compareTo(o2.name());
        }
        if (o1.surname() == null || o2.surname() == null) {
            return o1.surname() == null ? o1.name().compareTo(o2.surname())
                : o1.surname().compareTo(o2.name());
        }
        return o1.surname().compareTo(o2.surname()) == 0
            ? o1.name().compareTo(o2.name())
            : o1.surname().compareTo(o2.surname());
    }

    public static Object[] parseContacts(String[] contacts, ParseMode mode) {
        if (contacts == null) {
            return new Object[0];
        }
        var newContacts = Arrays.stream(contacts).map(contact -> contact.split(" "))
            .map(contact -> new FullName(contact[0], contact.length > 1 ? contact[1] : null)).toList();
        var map = new Hashtable<FullName, String>();
        for (var i = 0; i < contacts.length; i++) {
            map.put(newContacts.get(i), contacts[i]);
        }
        Comparator<FullName> comparator;
        if (mode == ParseMode.ASC) {
            comparator = ContactsParser::comparator;
        } else {
            comparator = (o1, o2) -> comparator(o2, o1);
        }
        var result = new TreeSet<>(comparator);
        result.addAll(newContacts);
        return result.stream().map(map::get).toArray();
    }
}
