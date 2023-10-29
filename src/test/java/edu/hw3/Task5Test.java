package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task5.ContactsParser.parseContacts;
import static edu.hw3.Task5.ContactsParser.ParseMode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    public void isWorkCorrectWithASCModeTest() {
        assertThat(parseContacts(new String[] { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" },
        ParseMode.ASC)).isEqualTo(new Object[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"});
    }
    @Test
    public void isWorkCorrectWithDESCModeTest() {
        assertThat(parseContacts(new String[] { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" },
            ParseMode.DESC)).isEqualTo(new Object[] {"John Locke", "David Hume", "Rene Descartes", "Thomas Aquinas"});
    }

    @Test
    public void isWorkCorrectWithNoSurnameContactsTest() {
        assertThat(parseContacts(new String[] { "John Locke", "Thomas Aquinas", "David", "Rene Descartes" },
            ParseMode.ASC)).isEqualTo(new Object[] {"Thomas Aquinas", "David", "Rene Descartes",  "John Locke"});
    }
    @Test
    public void isWorkCorrectWithSameSurnameContactsTest() {
        assertThat(parseContacts(new String[] { "Thomas Aquinas", "John Aquinas" },
            ParseMode.ASC)).isEqualTo(new Object[] {"John Aquinas", "Thomas Aquinas"});
    }
    @Test
    public void isWorkCorrectDESCModeTest() {
        assertThat(parseContacts(new String[] { "Paul Erdos", "Leonhard Euler", "Carl Gauss" },
            ParseMode.DESC)).isEqualTo(new Object[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"});
    }
    @Test
    public void isWorkCorrectWithEmptyArrayTest() {
        assertThat(parseContacts(new String[] {},
            ParseMode.ASC)).isEqualTo(new Object[] {});
    }
    @Test
    public void isWorkCorrectWithNullArrayTest() {
        assertThat(parseContacts(null,
            ParseMode.ASC)).isEqualTo(new Object[] {});
    }
}
