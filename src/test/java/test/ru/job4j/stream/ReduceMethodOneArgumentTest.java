package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.ReduceMethodOneArgument;

import java.util.List;

import static org.junit.Assert.*;

public class ReduceMethodOneArgumentTest {
    @Test
    public void test() {
        Assert.assertEquals(Integer.valueOf(1), ReduceMethodOneArgument.reduce(List.of(1)));
        assertEquals(Integer.valueOf(6), ReduceMethodOneArgument.reduce(List.of(1, 2, 3)));
        assertEquals(Integer.valueOf(24), ReduceMethodOneArgument.reduce(List.of(1, 2, 3, 4)));
    }

}