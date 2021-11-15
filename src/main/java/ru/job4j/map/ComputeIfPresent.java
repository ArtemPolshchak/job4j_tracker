package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer num : name.keySet()) {
            name.computeIfPresent(num, (k, v) -> v + " " + surname.get(num));
        }

        return name;
    }
}
