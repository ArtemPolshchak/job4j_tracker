package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ComputeIfPresentTest {
    @Test
    public void collectData() {
        Map<Integer, String> name = new HashMap<>(Map.of(1, "Bill", 2, "Donald"));
        Map<Integer, String> surname = new HashMap<>(Map.of(1, "Clinton", 2, "Trump"));
        Map<Integer, String> rsl = ComputeIfPresent.collectData(name, surname);
        Map<Integer, String> expected = Map.of(1, "Bill Clinton", 2, "Donald Trump");
        assertThat(rsl, is(expected));
    }
}