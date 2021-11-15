package ru.job4j.set;

import java.util.*;

public class Isogram {
    public static boolean checkString(String s) {
        List<String> firstList = new ArrayList<>(Arrays.asList(s.split("")));
        Set<String> secondList = new HashSet<>(firstList);
        return secondList.size() == firstList.size();

    }
}
