package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FullSearchTest {
    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First disc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<String> expected = new HashSet<>(List.of("1", "2"));
        assertThat(FullSearch.extraNumber(tasks), is(expected));
    }

    @Test
    public void extractNumbers() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First disc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc"),
                new Task("3", "First disc"),
                new Task("4", "Second desc"),
                new Task("5", "First desc"),
                new Task("3", "First desc")
        );
        Set<String> expected = new HashSet<>(List.of("1", "2", "3", "4", "5"));
        assertThat(FullSearch.extraNumber(tasks), is(expected));
    }
}