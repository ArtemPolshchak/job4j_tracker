package ru.job4j.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortWithObject {
    public static String[] sort(String[] data) {
        Arrays.sort(data, Comparator.reverseOrder());
        return data;
    }
}
