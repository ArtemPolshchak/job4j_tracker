package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.StreamOfMethod;

import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class StreamOfMethodTest {
    @Test
    public void whenUserStreamMethod() {
        Assert.assertEquals("abc",
                StreamOfMethod.createStream().
                map(Object::toString).collect(Collectors.joining()));
    }

}