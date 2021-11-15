package ru.job4j.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IsogramTest {
    @Test
    public void checkStringTrue() {
        String s = "uncopyrightables";
        boolean b = Isogram.checkString(s);
        assertThat(b, is(true));
    }

    @Test
    public void checkStringFalse() {
        String s = "javascript";
        boolean b = Isogram.checkString(s);
        assertThat(b, is(false));
    }
}