package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {

    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        return  Stream.of(it)
                .flatMap(FlatIt::iteratorToStream)
                .flatMap(s -> iteratorToStream(s))
                .collect(Collectors.toList());
    }

    private static <T> Stream<T> iteratorToStream(Iterator<T> it) {
        return StreamSupport.
                stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false);
    }
}
