package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> strings = new ArrayList<>();

        BiConsumer<Integer, String> biCon = map::put;

        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");

        BiPredicate<Integer, String> biPred = (s, i) -> s % 2 == 0 || i.length() == 4;

        Consumer<String> con = System.out::println;

        Function<String, String> func = String::toUpperCase;

        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                strings.add(map.get(i));
            }

        }
        Supplier<List<String>> sup = () -> new ArrayList<>(strings);

        for (String s : sup.get()) {
            con.accept(func.apply(s));

        }
    }
}