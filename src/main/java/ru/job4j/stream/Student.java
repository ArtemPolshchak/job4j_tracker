package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String surname;

    public Student() {
    }

    public Student(String surname) {
        this.surname = surname;
    }

    public Student(int score, String surname) {
        this.surname = surname;
        this.score = score;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), getSurname());
    }
}
