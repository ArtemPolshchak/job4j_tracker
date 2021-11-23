package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MinMethodTest {
    @Test
    public void test() {
        assertEquals(
                "a",
                MinMethod.min(List.of("ccc", "bb", "a"))
        );
    }

}