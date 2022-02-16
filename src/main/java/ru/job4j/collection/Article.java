package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem.polschak@gmail.com on 14.02.2021.
 * метод проверяет, что новый текст был получен из оригинального.
 */
public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean result = true;
        List<String> res = new ArrayList<>();
        String[] originList = origin.split("\\s");
        String[] lineList = line.split("\\s");
        for (String s : originList) {
           String num = s.replaceAll("[^A-Za-zА-Яа-я0-9 ]", "");
           res.add(num);

        }
        for (String s : lineList) {
            if (!res.contains(s)) {
                result = false;
                break;

            }
        }
        return result;
    }

}
