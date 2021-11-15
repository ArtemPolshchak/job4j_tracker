package ru.job4j.list;

import java.util.*;

public class Alphabet {
    public static String reformat(String s) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, s.split(""));
        Collections.sort(list);
        for (String value : list) {
            builder.append(value);
        }
        return builder.toString();
    }
}
