package ru.job4j.map;

import java.security.Key;
import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        char rsl = ' ';
            String one = str.replaceAll("\\s+", "");
            String two  = one.toLowerCase(Locale.ROOT);
        ArrayList<Character> list = new ArrayList<>();

        for (char num : two.toCharArray()) {
            list.add(num);
        }
        TreeMap<String, Integer> map = new TreeMap<>();
        for (Character c : list) {
            map.putIfAbsent(String.valueOf(c), 0);
            map.computeIfPresent(String.valueOf(c), (k, v) -> v + 1);
        }

            int maxValueInMap = (Collections.max(map.values()));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                String last = entry.getKey();
                rsl = last.charAt(0);
                break;
            }
        }

        return rsl;
    }

    public static void main(String[] args) {
        String f = "Artem  " + "Polschak";
        String d = f.replaceAll("\\s+", "");
         String s  = d.toLowerCase(Locale.ROOT);
        System.out.println(s);
        ArrayList<Character> chars = new ArrayList<>();
        for (char n : s.toCharArray()) {
            chars.add(n);
        }
        for (char b : chars) {
            System.out.println(b);
        }
    }
}
