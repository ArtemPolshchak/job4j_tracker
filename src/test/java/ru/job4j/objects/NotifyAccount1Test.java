package ru.job4j.objects;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NotifyAccount1Test {

    @Test
    public void sent() {
        List<Account1> accounts = Arrays.asList(
                new Account1("123", "Petr Arsentev", "eDer3432f"),
                new Account1("142", "Petr Arsentev", "000001")
        );
        HashSet<Account1> expect = new HashSet<>(
                Arrays.asList(
                        new Account1("123", "Petr Arsentev", "eDer3432f"),
                        new Account1("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void deleteDouble() {
        List<Account1> accounts = Arrays.asList(
                new Account1("123", "Petr Arsentev", "eDer3432f"),
                new Account1("123", "Petr Arsentev", "eDer3432f"),
                new Account1("142", "Petr Arsentev", "000001"),
                new Account1("142", "Petr Arsentev", "000001")
        );
        HashSet<Account1> expect = new HashSet<>(
                Arrays.asList(
                        new Account1("123", "Petr Arsentev", "eDer3432f"),
                        new Account1("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}