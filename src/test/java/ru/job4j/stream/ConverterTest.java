package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.stream.ConverterMatrix.convertMatrix;

import java.util.List;

public class ConverterTest {
    @Test
    public void testMatrix() {
        Integer[][] matrix = new Integer[][] {
                {1, 2}, {3, 4, 5}
        };
        List<Integer> result = convertMatrix(matrix);
        List<Integer> expected = List.of(
                1, 2, 3, 4, 5
        );

        assertThat(result, is(expected));
    }
}