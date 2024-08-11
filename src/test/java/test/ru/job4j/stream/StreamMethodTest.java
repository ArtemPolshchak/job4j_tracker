package test.ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.stream.StreamMethod;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author User on 23.11.2021.
 * @project job4j_tracker
 */
public class StreamMethodTest {
    @Test
    public void whenUserStreamMethod() {
        Assert.assertEquals(3, StreamMethod.createStream(
                List.of(1, 2, 3)
        ).count());
    }

}