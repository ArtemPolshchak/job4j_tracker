package ru.job4j.set;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PangramTest {
    @Test
    public void checkString() {
        String str = "Jackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(true));
    }
}