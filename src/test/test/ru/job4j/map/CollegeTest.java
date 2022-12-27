package ru.job4j.map;

import org.junit.Test;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Artem Polshchak 09.12.2021.
 * @project job4j_tracker
 */
public class CollegeTest {
    @Test
    public void whenAccountIsOptionalEmpty() {
        Map<Student, Set<Subjects>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subjects("Economic", 75),
                        new Subjects("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findByAccount("000010"), is(Optional.empty()));
    }

    @Test
    public void whenAccountIsOptionalNotEmpty() {
        Map<Student, Set<Subjects>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subjects("Economic", 75),
                        new Subjects("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findByAccount("000001").get().getGroup(), is("201-18-15"));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithNotFoundAccount() {
        Map<Student, Set<Subjects>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subjects("Economic", 75),
                        new Subjects("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000010", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalEmptyWithFoundAccount() {
        Map<Student, Set<Subjects>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subjects("Economic", 75),
                        new Subjects("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000001", "Sociology"), is(Optional.empty()));
    }

    @Test
    public void whenSubjectIsOptionalNotEmpty() {
        Map<Student, Set<Subjects>> students = Map.of(
                new Student("Student1", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                ),
                new Student("Student2", "000002", "201-18-15"),
                Set.of(
                        new Subjects("Economic", 75),
                        new Subjects("Sociology", 65)
                )
        );
        College college = new College(students);
        assertThat(college.findBySubjectName("000002", "Sociology").get().getScore(), is(65));
    }
}