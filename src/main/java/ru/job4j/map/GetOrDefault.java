package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrDefault {
    private Map<Integer, List<String>> store = new HashMap<>();

    public void addValue(int index, List<String> list) {
        store.putIfAbsent(index, list);

    }

    public List<String> getValue(int index) {
    List<String> l = new ArrayList<>();
        return store.getOrDefault(index, l);
    }
}
