package ru.job4j.comparator;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class NaturalOrderTest {

    @Test
    public void test() {
        assertEquals(Comparator.naturalOrder(), NaturalOrder.naturalOrder());
    }

}