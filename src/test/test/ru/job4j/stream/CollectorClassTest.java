package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CollectorClassTest {
    @Test
    public void test() {
        assertEquals(
            List.of(1, 2, 3),
        CollectorClass.collect(List.of(1, 2, 3))
        );
    }
}