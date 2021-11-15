package ru.job4j.set;


import java.util.HashSet;
import java.util.Set;

public class Pangram {
    public static boolean checkString(String s) {
        char[] chars = s.toCharArray();
        for (char num : chars) {
            if (Character.isLetter(num)) {
                return true;
            }
        }
        return false;
    }
}