package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ReductionWithTwoArguments {
    public static Integer collect(List<Integer> list) {
        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Integer> consumer = List::add;
        BinaryOperator<List<Integer>> merger = (xs, ys) -> {
            xs.addAll(ys);
            return xs;
        };
        Function<List<Integer>, Integer> function = (ns) -> {
            int res = 5;
            for (Integer l : ns) {
                    res *= l;
                }
            return res;
        };
        return list.stream()
                .collect(Collector.of(supplier, consumer, merger, function));

    }
}
