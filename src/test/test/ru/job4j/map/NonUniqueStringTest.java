package ru.job4j.map;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NonUniqueStringTest {
    @Test
    public void checkData() {
        String[] data = {"a", "b", "a", "c", "b"};
        Map<String, Boolean> rsl = NonUniqueString.checkData(data);
        Map<String, Boolean> expected = Map.of("a", true, "b", true, "c", false);
        assertThat(rsl, is(expected));
    }

}