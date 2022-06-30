package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Artem.polschak@gmail.com on 14.02.2022.
 * @project job4j_tracker
 * метод проверки корректности открытых и закрытых скобок.
 */

public class ParenthesesTest {

    @Test
    public void whenValidInner() {
        assertThat(
                Parentheses.valid(new char[] {'(', '(', ')', ')'}),
                is(true)
        );
    }

    @Test
    public void whenValidSeq() {
        assertThat(
                Parentheses.valid(new char[] {'(', ')', '(', ')'}),
                is(true)
        );
    }

    @Test
    public void whenInValidInner() {
        assertThat(
                Parentheses.valid(new char[] {')', ')', '(', '('}),
                is(false)
        );
    }

    @Test
    public void whenInValidSeq() {
        assertThat(
                Parentheses.valid(new char[] {'(', ')', '(', '('}),
                is(false)
        );
    }
}