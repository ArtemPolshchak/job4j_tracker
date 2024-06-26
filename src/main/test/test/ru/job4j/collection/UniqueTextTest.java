package test.ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.UniqueText;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UniqueTextTest {
    @Test
    public void isEquals() {
        String origin = "My cat eats a mouse and milk";
        String text = "My cat eats milk and a mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isNotEquals() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEquals(origin, text), is(false));
    }

    @Test
    public void isEql2() {
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

    @Test
    public void isEql3() {
        String origin = "My cat eats a mouse and drink water";
        String text = "My cat drink water and eats a mouse";
        assertThat(UniqueText.isEquals(origin, text), is(true));
    }

}