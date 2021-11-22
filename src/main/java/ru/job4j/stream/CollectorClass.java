package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author Artem Polshchak on 21.11.2021.
 * @project job4j_tracker
 */
public class CollectorClass {
    public static List<Integer> collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = LinkedList::new;
        BiConsumer<List<Integer>, Integer> biConsumer = List::add;
                BinaryOperator<List<Integer>> operator = (left, right) -> {
            left.addAll(right);
            return left;
                };
        return list.stream().collect(Collector.of(supplier, biConsumer, operator));

    }
}
