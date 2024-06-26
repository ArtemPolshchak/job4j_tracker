package test.ru.job4j.list;

import org.junit.Test;
import ru.job4j.list.AddIndexElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AddIndexElementTest {
    @Test
    public void addNewElementTrue() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        boolean result = AddIndexElement.addNewElement(list, 1, "fourth");
        assertThat(result, is(true));
    }

    @Test
    public void addNewElementFalse() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        boolean result = AddIndexElement.addNewElement(list, 1, "second");
        assertThat(result, is(false));
    }

}