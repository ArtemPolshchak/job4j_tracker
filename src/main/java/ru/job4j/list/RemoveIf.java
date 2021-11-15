package ru.job4j.list;

import java.util.List;

public class RemoveIf {
    public static List<String> sortList(List<String> list) {
            list.removeIf(x -> x.length() < 5);

        return list;
    }
}
