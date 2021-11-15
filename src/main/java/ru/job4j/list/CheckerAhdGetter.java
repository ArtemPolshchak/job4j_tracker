package ru.job4j.list;

import java.util.List;

public class CheckerAhdGetter {
    public static String getElement(List<String> list) {
        String result = "";
        for (String s : list) {
            if (!s.isEmpty()) {
                result = s;
                break;
            }
        }
        return result;
    }
}
