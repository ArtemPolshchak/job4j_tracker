package test.ru.job4j.list;

import org.junit.Test;
import ru.job4j.list.Alphabet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AlphabetTest {
    @Test
    public void reformat() {
        String rsl = Alphabet.reformat("javascript");
        String expected = "aacijprstv";
        assertThat(rsl, is(expected));
    }

    @Test
    public void reformat1() {
        String rsl = Alphabet.reformat("websecurityconfigureradapter");
        String expected = "aabccdeeeefgiinoprrrrsttuuwy";
        assertThat(rsl, is(expected));
    }
}