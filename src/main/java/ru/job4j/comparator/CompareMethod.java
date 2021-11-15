package ru.job4j.comparator;

public class CompareMethod {
    public static int ascendingCompare(int first, int second) {
        return Integer.compare(first - second, 0);
    }

    public static int descendingCompare(int first, int second) {
        return Integer.compare(second - first, 0);
    }

}
