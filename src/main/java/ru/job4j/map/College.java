package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subjects>> students;

    public College(Map<Student, Set<Subjects>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();

    }

    public Optional<Subjects> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        Optional<Subjects> rsl = Optional.empty();
        if (student.isPresent()) {
           rsl = students.get(student.get())
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst();

        }
        return rsl;
    }

    public static void main(String[] args) {
       Map<Student, Set<Subjects>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subjects("Math", 70),
                        new Subjects("English", 85)
                )
        );

        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент : " + student);
        Optional<Subjects> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english);

    }
}
