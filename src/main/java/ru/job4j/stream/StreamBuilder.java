package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * @author User on 25.11.2021.
 * @project job4j_tracker
 */
public class StreamBuilder {
    public static Stream<Object> createStream(Integer[] data) {
        return Stream.builder().add(1).add(3).build();

    }
}
