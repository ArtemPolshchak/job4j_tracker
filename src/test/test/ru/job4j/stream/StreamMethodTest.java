package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author User on 23.11.2021.
 * @project job4j_tracker
 */
public class StreamMethodTest {
    @Test
    public void whenUserStreamMethod() {
        assertEquals(3, StreamMethod.createStream(
                List.of(1, 2, 3)
        ).count());
    }

}