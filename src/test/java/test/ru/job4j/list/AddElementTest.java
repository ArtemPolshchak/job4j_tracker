package test.ru.job4j.list;

import org.junit.Test;

import org.junit.Test;
import ru.job4j.list.AddElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AddElementTest {
    @Test
    public void addNewElement() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        boolean result = AddElement.addNewElement(list, "fourth");
        assertThat(result, is(true));
    }
}