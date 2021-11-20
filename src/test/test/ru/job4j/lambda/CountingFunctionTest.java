package ru.job4j.lambda;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class CountingFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountingFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        List<Double> result = CountingFunction.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenIndicativeResults() {
        List<Double> result = CountingFunction.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }

}