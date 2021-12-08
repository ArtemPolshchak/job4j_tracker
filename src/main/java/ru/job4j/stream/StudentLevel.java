package ru.job4j.stream;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс содержит один метод, который реализует фильтрацию учеников.
 * @author ARTEM POLSHCHAK
 * @version 1.0
 */

public class StudentLevel {
    /**
     * Метод реализует фильтрацию учеников по проходному баллу, т.е. по полю score.
     * @param students список студентов
     * @param bound проходной бал для студентов
     * @return возвращает список студентов, у которых балл аттестата больше bound.
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
