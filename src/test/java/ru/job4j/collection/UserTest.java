package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

    public class UserTest {
        @Test
        public void whenAsc() {
            Set<User> users = new TreeSet<>();

            users.add(new User("Petr", 32));
            users.add(new User("Petr", 31));
            users.add(new User("Ivan", 31));
            users.add(new User("Artem", 20));
            users.add(new User("Artem", 10));

            Iterator<User> it = users.iterator();
            assertThat(it.next(), is(new User("Artem", 10)));
            assertThat(it.next(), is(new User("Artem", 20)));
            assertThat(it.next(), is(new User("Ivan", 31)));
            assertThat(it.next(), is(new User("Petr", 31)));
            assertThat(it.next(), is(new User("Petr", 32)));

        }

        @Test
        public void whenComparePertVSIvan() {
            int rsl = new User("Petr", 32)
                    .compareTo(
                            new User("Ivan", 31)
                    );
            assertThat(rsl, greaterThan(0));
        }
    }