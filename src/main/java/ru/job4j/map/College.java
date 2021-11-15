package ru.job4j.map;

import java.util.Map;
import java.util.Set;

/**
 * @author Artem Polshchak on 29.10.2021.
 * @project job4j-tracker
 */
public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                return s;
            }
        }
        return null;
    }

    public Subject findBySubjectName(String account, String name) {
        Student a = findByAccount(account);
        if (a != null) {
            Set<Subject> subjects = students.get(a);
            for (Subject s : subjects) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );

        College college = new College(students);
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент : " + student);
        Subject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());

    }

}
