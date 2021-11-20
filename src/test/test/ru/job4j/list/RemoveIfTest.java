package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RemoveIfTest {
    @Test
    public void when() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");
        List<String> expected = List.of("three", "seven", "eight");
        List<String> result = RemoveIf.sortList(list);
        assertThat(result, is(expected));
    }
}