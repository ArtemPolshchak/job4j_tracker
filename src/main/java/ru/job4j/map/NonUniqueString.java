package ru.job4j.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> mapStr = new HashMap<>();
        for (String str : strings) {
            mapStr.computeIfPresent(str, (k, v) -> true);
            mapStr.putIfAbsent(str, false);
        }
        return mapStr;
    }
}
