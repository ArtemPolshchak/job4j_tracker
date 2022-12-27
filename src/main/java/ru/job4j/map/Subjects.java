package ru.job4j.map;

import java.util.Objects;

/**
 * @author Artem Polshchak on 29.10.2021.
 * @project job4j-tracker
 */
public class Subjects {
    private String name;
    private int score;

    public Subjects(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subjects)) {
            return false;
        }
        Subjects subject = (Subjects) o;
        return getScore() == subject.getScore() && Objects.equals(getName(), subject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore());
    }

    @Override
    public String
    toString() {
        return "Subject{" + "name='"
                + name + '\'' + ", score="
                + score + '}';
    }
}
