package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.ArraysStreamMethod;

import static org.junit.Assert.*;

public class ArraysStreamMethodTest {
    @Test
    public void test() {
        Integer[] data = {1, 2, 3};
        Assert.assertEquals(3, ArraysStreamMethod.createStream(data).count());
    }
}