package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RepositionElementTest {
    private List<String> list = new ArrayList<>();

    @Before
    public void setUp() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
    }

    @Test
    public void changePosition() {
        int index = 3;
        List<String> result = RepositionElement.changePosition(list, index);
        assertThat(result.size(), is(8));
        assertThat(result.get(index), is("nine"));
    }

    @Test
    public void changePositionNone() {
        int index = 20;
        List<String> result = RepositionElement.changePosition(list, index);
        assertThat(result.size(), is(8));
        assertThat(result.contains("nine"), is(false));
    }
}