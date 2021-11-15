package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Используется для фильтра обьектов Folder
 * @author Atrem Pols
 **/

public class SearchFolder {
    /**
     * Метод фильтрует объекты Folder по name и size
     * @param list <Folder> список обьектов
     * @param pred <Folder> возвращает true false
     * @return rsl <Folder> коллекция объектов Folder,
     * которые удовлетворяют условия Predicate<Folder> pred
     **/
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}

