package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {

        String[] words = {
                "a",
                "dok",
                "ci",
                "bocok",
                "even"
        };

        Comparator<String> cmpDescSize = (
                left, right) -> Integer.compare(right.length(), left.length()
        );

        Comparator<String> cmpText = String::compareTo;

        Arrays.sort(words, cmpDescSize);
        Arrays.sort(words, cmpText);

        for (String s : words) {
            System.out.println(s);
        }
    }
}
