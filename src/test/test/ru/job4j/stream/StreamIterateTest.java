package ru.job4j.stream;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author User on 25.11.2021.
 * @project job4j_tracker
 */
public class StreamIterateTest {
    @Test
    public void test() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Integer[] data = {1, 2, 3, 4};
        StreamIterate.showArray(data);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("1" + ln + "3" + ln));
    }

}