package ru.job4j.collection;

import java.util.*;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        list.sort(Collections.reverseOrder());
        System.out.println(list);

    }
}
