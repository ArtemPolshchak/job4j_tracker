package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * @author User on 25.11.2021.
 * @project job4j_tracker
 */
public class ArraysStreamForPrimitiveTest {
    @Test
    public void test() {
        int[] data = {1, 2, 3};
        List<Integer> result = ArraysStreamForPrimitive.createStream(data)
                .boxed().collect(Collectors.toList());
        List<Integer> expect = List.of(1, 2, 3);
        assertEquals(expect, result);
    }
}