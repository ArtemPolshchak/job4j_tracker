package ru.job4j.map;

/**
 * @author artem.polschak@gmail.com on 27.12.2022.
 * @project job4j_tracker
 * The class contains the results: name and scores.
 * This class is used for both students and subjects.
 */
public record Label(String name, double score) implements Comparable<Label> {
    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
