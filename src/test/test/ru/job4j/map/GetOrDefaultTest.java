package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GetOrDefaultTest {
    @Test
    public void whenGetList() {
        List<String> list = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, list);
        get.addValue(2, second);
        List<String> value = get.getValue(2);
        assertThat(value, is(second));
    }

    @Test
    public void whenGetListEmpty() {
        List<String> list = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, list);
        get.addValue(2, second);
        List<String> value = get.getValue(10);
        assertThat(value, is(new ArrayList<>()));
    }

    @Test
    public void whenAddListWithDuplicateKey() {
        List<String> list = List.of("one", "two", "three");
        List<String> second = List.of("four", "five", "six");
        List<String> third = List.of("seven", "eight", "nine");
        GetOrDefault get = new GetOrDefault();
        get.addValue(1, list);
        get.addValue(2, second);
        get.addValue(1, third);
        List<String> value = get.getValue(1);
        assertThat(value, is(list));
    }
}