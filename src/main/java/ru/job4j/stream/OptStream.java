package ru.job4j.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author User on 09.12.2021.
 * @project job4j_tracker
 */
public class OptStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Optional<Integer> rsl = stream.filter(integer -> integer == 5).findFirst();
        if (rsl.isPresent()) {
            System.out.println(rsl.get());
        } else {
            System.out.println("Element not found.");
        }
    }
}
