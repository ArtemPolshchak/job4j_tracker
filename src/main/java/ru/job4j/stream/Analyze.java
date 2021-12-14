package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Artem Polshchak on 10.12.2021.
 * @project job4j_tracker  2. Аттестация [#49777]
 */
public class Analyze {

    /**
     * Метод вычисляет общий средний балл
     * @param stream принимает на вход для осуществления поиска среднего балла учеников
     * @return общий средний бал учеников
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore).average().orElse(0D);
    }

    /**
     * Метод вычисляет средний балл ученика по его предметам.
     * Возвращает список из объекта Tuple (имя ученика и средний балл).
     * @param stream принимает на вход для осуществления поиска среднего балла одного ученика
     *               по его предметам
     * @return средний бал ученика по его предметам.
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {

        return stream.map(n -> new Tuple(n.getName(), n.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D))).collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream принимает на вход для осуществления поиска среднего балла для каждого ученика
     * @return список из объекта Tuple (название предмета и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(),
                        tuple.getValue())).collect(Collectors.toList());
    }

    /**
     * Метод осуществляет поиск лучшего ученика по всем предметам
     * @param stream принимает на вход для осуществления поиска лучшего ученика
     * @return метод возвращает лучшего ученика.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }

    /**
     * Метод возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream принимает на вход для осуществления
     *               поиска предмета с наибольшим баллом для всех студентов.
     * @return объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(tuple -> new Tuple(tuple.getKey(),
                        tuple.getValue())).max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }
}
