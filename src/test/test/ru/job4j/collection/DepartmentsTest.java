package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * DepartmentsTest
 */
public class DepartmentsTest {
    /**
     * Test. whenMissed
     */
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    /**
     * Test. whenNonChange
     */
    @Test
    public void whenNonChange() {
        List<String> input  = Arrays.asList("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    /**
     * Test. ascendingSortTest
     */
    @Test
    public void ascendingSortTest() {
        List<String> input = Arrays.asList(
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K2/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1",
                "K2/SK1/SSK2",
                "K2/SK1",
                "K2"
        );

        List<String> expected = List.of(
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2",
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2"
        );

        List<String> result = Departments.sortAsc(input);
        assertThat(result, is(expected));
    }

    /**
     * Test. descendingSortTest
     */
    @Test
    public void descendingSortTest() {
        List<String> input  = Arrays.asList(
                "K2/SK1",
                "K1/SK1/SSK2",
                "K2",
                "K2/SK1/SSK1",
                "K1",
                "K2/SK1/SSK2",
                "K1/SK1",
                "K1/SK2",
                "K1/SK1/SSK1"
        );
        List<String> expect = List.of(
                "K2",
                "K2/SK1",
                "K2/SK1/SSK1",
                "K2/SK1/SSK2",
                "K1",
                "K1/SK1",
                "K1/SK1/SSK1",
                "K1/SK1/SSK2",
                "K1/SK2"

        );

        List<String> result =  Departments.sortDesc(input);
        assertThat(result, is(expect));
    }

    /**
     * Test. equalsTest
     */
    @Test
    public void equalsTest() {
        String[] expected = {
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        };
        String[] result = {
                "K2",
                "K2/SK1",
                "K2/SK1/SSK2",
                "K2/SK1/SSK1",
                "K1",
                "K1/SK2",
                "K1/SK1",
                "K1/SK1/SSK2",
                "K1/SK1/SSK1"
        };
        assertThat(result, is(expected));
    }
}