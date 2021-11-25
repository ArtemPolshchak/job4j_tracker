package ru.job4j.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author User on 25.11.2021.
 * @project job4j_tracker
 */
public class ArraysStreamMethod {
    public static Stream<Integer> createStream(Integer[] data) {
        return Arrays.stream(data);
    }
}
