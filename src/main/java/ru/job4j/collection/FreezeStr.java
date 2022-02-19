package ru.job4j.collection;

import java.util.Arrays;

/**
 * @author Artem.polschak@gmail.com on 14.02.2021.
 * Проверить две строчки на идентичность.
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean result = true;
        String[] first = left.split("");
        String[] second = right.split("");

        Arrays.sort(first);
        Arrays.sort(second);

        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) {
                result = false;
                break;
            }
        }

        return result;
    }
}
