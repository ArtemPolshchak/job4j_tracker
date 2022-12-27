package ru.job4j.map;

import java.util.List;

/**
 * @author artem.polschak@gmail.com on 27.12.2022.
 * @project job4j_tracker
 * class describes a student.
 */
public record Pupil(String name, List<Subject> subjects) {
}
