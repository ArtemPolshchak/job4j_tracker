package test.ru.job4j.comparator;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.comparator.CompareMethod;

import static org.junit.Assert.*;

public class CompareMethodTest {
    @Test
    public void testAscending() {
        Assert.assertEquals(0, CompareMethod.ascendingCompare(1, 1));
        assertEquals(-1, CompareMethod.ascendingCompare(1, 2));
        assertEquals(1, CompareMethod.ascendingCompare(2, 1));
    }

    @Test
    public void testDescending() {
        assertEquals(0, CompareMethod.descendingCompare(1, 1));
        assertEquals(1, CompareMethod.descendingCompare(1, 2));
        assertEquals(-1, CompareMethod.descendingCompare(2, 1));
    }

}