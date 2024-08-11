package test.ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.stream.CollectorClass;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class CollectorClassTest {
    @Test
    public void test() {
        TestCase.assertEquals(
            List.of(1, 2, 3),
        CollectorClass.collect(List.of(1, 2, 3))
        );
    }
}