package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.ReductionWithTwoArguments;

import java.util.List;

import static org.junit.Assert.*;

public class ReductionWithTwoArgumentsTest {
    @Test
    public void test() {
        Assert.assertEquals(Integer.valueOf(5), ReductionWithTwoArguments.collect(List.of()));
        assertEquals(Integer.valueOf(5), ReductionWithTwoArguments.collect(List.of(1)));
        assertEquals(Integer.valueOf(10), ReductionWithTwoArguments.collect(List.of(1, 2)));
        assertEquals(Integer.valueOf(30), ReductionWithTwoArguments.collect(List.of(1, 2, 3)));
    }
}