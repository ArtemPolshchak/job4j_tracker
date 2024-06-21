package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.MinMethod;

import java.util.List;

import static org.junit.Assert.*;

public class MinMethodTest {
    @Test
    public void test() {
        Assert.assertEquals(
                "a",
                MinMethod.min(List.of("ccc", "bb", "a"))
        );
    }

}