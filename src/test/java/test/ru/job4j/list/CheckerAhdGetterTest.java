package test.ru.job4j.list;


import org.junit.Test;
import ru.job4j.list.CheckerAhdGetter;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CheckerAhdGetterTest {
    @Test
    public void whenGetNull() {
        List<String> list = new ArrayList<>();
        String result = CheckerAhdGetter.getElement(list);
        String expected = "";
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetFirstElement() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        String result = CheckerAhdGetter.getElement(list);
        String expected = "first";
        assertThat(result, is(expected));
    }
}