package edu.hw3.Task5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ContactsParser {
    private ContactsParser() {
    }

    public enum ParseMode {
        ASC,
        DESC
    }

    private static int comparator(String o1, String o2) {
        var fullName1 = o1.split(" ");
        var fullName2 = o2.split(" ");
        if (fullName1.length < 2 && fullName2.length < 2) {
            return o1.compareTo(o2);
        }
        if (fullName1.length < 2 || fullName2.length < 2) {
            return fullName1.length < 2 ? fullName1[0].compareTo(fullName2[1])
                : fullName1[1].compareTo(fullName2[0]);
        }
        return fullName1[1].compareTo(fullName2[1]) == 0
            ? fullName1[0].compareTo(fullName2[0])
            : fullName1[1].compareTo(fullName2[1]);
    }

    public static Object[] parseContacts(String[] contacts, ParseMode mode) {
        if (contacts == null) {
            return new Object[0];
        }
        Comparator<String> comparator;
        if (mode == ParseMode.ASC) {
            comparator = ContactsParser::comparator;
        } else {
            comparator = (o1, o2) -> comparator(o2, o1);
        }
        var result = new TreeSet<>(comparator);
        result.addAll(Arrays.asList(contacts));
        return result.toArray();
    }
}
