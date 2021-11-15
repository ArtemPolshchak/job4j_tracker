package ru.job4j.set;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class JackpotTest {
    @Test
    public void checkYourWinTrue() {
        String[] strings = {"@", "@", "@", "@"};
        boolean win = Jackpot.checkYourWin(strings);
        assertThat(win, is(true));
    }

    @Test
    public void checkYourWinFalse() {
        String[] strings = {"&&", "&", "&&&", "&&&&"};
        boolean win = Jackpot.checkYourWin(strings);
        assertThat(win, is(false));
    }

}