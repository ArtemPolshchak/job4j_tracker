package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorArithmetic {
    public static Integer collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = LinkedList::new;
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        BinaryOperator<List<Integer>> merger = (xs, ys) -> {
            xs.addAll(ys);
            return xs;
        };
        Function<List<Integer>, Integer> function = (ns) -> {
            int res = 1;
            try {
                for (Integer l : ns) {
                    res *= l;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        };
        return list.stream()
                .collect(Collector.of(supplier, consumer, merger, function));
    }
}
