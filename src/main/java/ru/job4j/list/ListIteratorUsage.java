package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorUsage {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("one", "two", "three"));
        ListIterator<String> iterator = list.listIterator();
        System.out.println("Start iterate...");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Change direction iterate...");
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
        System.out.println("Finish iterate...");
    }
}