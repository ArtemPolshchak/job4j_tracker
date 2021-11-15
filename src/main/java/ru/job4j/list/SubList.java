package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        List<String> l = new ArrayList<>();
        if (!list.contains(el) || list.indexOf(el) == list.lastIndexOf(el)) {
            return l;
        } else {
            return list.subList(list.indexOf(el), list.lastIndexOf(el));
        }
    }
}
