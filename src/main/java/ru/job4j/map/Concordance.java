package ru.job4j.map;

import java.util.*;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String string) {
        string = string.replaceAll("\\s", "");
        Map<Character, List<Integer>> hashMap = new HashMap<>();
        List<Integer> listEmpty = new ArrayList<>();
        char[] list = string.toCharArray();

        for (Character s : list) {
            hashMap.putIfAbsent(s, listEmpty);
        }

        for (Character strFromKeySet : hashMap.keySet()) {
            List<Integer> listBuffer = new ArrayList<>();
            for (int i = 0; i < list.length; i++) {
                if (strFromKeySet.equals(list[i])) {
                    listBuffer.add(i);
                }
            }
            hashMap.computeIfPresent(strFromKeySet, (key, value) -> value = listBuffer);
        }
        return hashMap;
    }
}
