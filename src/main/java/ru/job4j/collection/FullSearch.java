package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extraNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();

        for (Task number : list) {
            numbers.add(number.getNumber());
        }
        return numbers;
    }
}
