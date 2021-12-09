package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();

    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> student = findByAccount(account);
        Optional<Subject> rsl = Optional.empty();
        if (student.isPresent()) {
           rsl = students.get(student.get())
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst();

        }
        return rsl;
    }

    public static void main(String[] args) {
       Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );

        College college = new College(students);
        Optional<Student> student = college.findByAccount("000001");
        System.out.println("Найденный студент : " + student);
        Optional<Subject> english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english);

    }
}
