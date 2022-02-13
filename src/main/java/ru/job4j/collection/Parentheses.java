package ru.job4j.collection;

/**
 * @author Artem.polschak@gmail.com on 14.02.2022.
 * @project job4j_tracker
 * метод проверки корректности открытых и закрытых скобок.
 */
public class Parentheses {
    public static boolean valid(char[] data) {
        boolean result = false;
        int count = 0;

        char first = '(';
        char second = ')';

        for (char s : data) {
           if (count < 0) {
               break;
           }
            if (s == first) {
                count++;
            } else if (s == second) {
                count--;
            }
        }

        if (count == 0) {
            result = true;
        }
        return result;
    }
}
