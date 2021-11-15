package ru.job4j.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        Set<String> list = new HashSet<>();
        Collections.addAll(list, combination);
        return list.size() <= 1;
    }
}
