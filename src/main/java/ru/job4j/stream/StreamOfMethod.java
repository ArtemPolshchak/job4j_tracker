package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamOfMethod {
    public static Stream<Character> createStream() {

        return Stream.of('a', 'b', 'c');

    }
}
