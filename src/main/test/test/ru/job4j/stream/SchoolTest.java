package test.ru.job4j.stream;

import org.junit.Test;
import ru.job4j.stream.School;
import ru.job4j.stream.Student;

import java.util.*;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest  {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = s -> s.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 50 && student.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void addUniqueStudentToMap() {
        List<Student> students = List.of(
                new Student("Surname1"),
                new Student("Surname4"),
                new Student("Surname5"),
                new Student("Surname7"),
                new Student("Surname9")
        );
        School sc = new School();
        Map<String, Student> rsl = sc.addStudent(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student("Surname1"));
        expected.put("Surname4", new Student("Surname4"));
        expected.put("Surname5", new Student("Surname5"));
        expected.put("Surname7", new Student("Surname7"));
        expected.put("Surname9", new Student("Surname9"));

        assertThat(rsl, is(expected));
    }

    @Test
    public void addDuplicateStudentToMap() {

        List<Student> students = List.of(
                new Student("Surname1"),
                new Student("Surname4"),
                new Student("Surname9"),
                new Student("Surname5"),
                new Student("Surname1"),
                new Student("Surname7"),
                new Student("Surname9")
        );
        School sc = new School();
        Map<String, Student> rsl = sc.addStudent(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student("Surname1"));
        expected.put("Surname4", new Student("Surname4"));
        expected.put("Surname5", new Student("Surname5"));
        expected.put("Surname7", new Student("Surname7"));
        expected.put("Surname9", new Student("Surname9"));

        assertThat(rsl, is(expected));
    }
}