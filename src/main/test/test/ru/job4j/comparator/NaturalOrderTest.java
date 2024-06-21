package test.ru.job4j.comparator;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.comparator.NaturalOrder;

import java.util.Comparator;

import static org.junit.Assert.*;

public class NaturalOrderTest {

    @Test
    public void test() {
        Assert.assertEquals(Comparator.naturalOrder(), NaturalOrder.naturalOrder());
    }

}