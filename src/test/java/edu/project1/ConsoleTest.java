package edu.project1;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class ConsoleTest {
    @Test
    public void guessReturnInputLetterTest() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        Console.setStream(in);
        var returnChar = Console.guess();
        assertThat(returnChar).isEqualTo("a");
        System.setIn(sysInBackup);
    }
}
