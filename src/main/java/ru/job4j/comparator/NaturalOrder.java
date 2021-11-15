package ru.job4j.comparator;

import java.util.Comparator;

public class NaturalOrder {
    public static Comparator<String> naturalOrder() {
        return Comparator.naturalOrder();
    }
}
