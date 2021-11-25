package ru.job4j.stream;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysStreamMethodTest {
    @Test
    public void test() {
        Integer[] data = {1, 2, 3};
        assertEquals(3, ArraysStreamMethod.createStream(data).count());
    }
}