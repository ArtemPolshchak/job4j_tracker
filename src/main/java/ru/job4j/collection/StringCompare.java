package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        int res = Math.min(first.length(), second.length());

        for (int i = 0; i < res; i++) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);

           int  result = Character.compare(c1, c2);
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(first.length(), second.length());
    }
}
