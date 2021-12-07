package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * @author User on 07.12.2021.
 * @project job4j_tracker
 */
public class DoubleLoop {
    public static void main(String[] args) {
        String[] levels = {"level 1", "level 2", "level 3"};
        String[] tasks = {"task 1", "task 2", "task 3", "task 4"};
        Stream.of(levels)
                .flatMap(level -> Stream.of(tasks)
                .map(task -> level + " " + task))
                .forEach(System.out::println);
    }
}
