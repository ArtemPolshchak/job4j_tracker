package ru.job4j.stream;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.List;

public class ProfilesTest {

    @Test
    public void whenIsDuplicate() {
        List<Profile> prof = List.of(
                new Profile(new Address("Кривой Рог", "Малиновая", 2, 21)),
                new Profile(new Address("Кривой Рог", "Малиновая", 2, 21)),
                new Profile(new Address("Харьков", "Зеленая", 21, 3)),
                new Profile(new Address("Киев", "Петровская", 34, 56)),
                new Profile(new Address("Киев", "Петровская", 34, 56))
        );

        List<Address> expected = List.of(
                new Address("Киев", "Петровская", 34, 56),
                new Address("Кривой Рог", "Малиновая", 2, 21),
                new Address("Харьков", "Зеленая", 21, 3)

        );
        Profiles profiles = new Profiles();

        List<Address> rsl = profiles.collect(prof);
         assertThat(rsl, is(expected));
    }

    @Test
    public void collectTestUnique() {
        List<Profile> prof = List.of(
                new Profile(new Address("Кривой Рог", "Малиновая", 2, 21)),
                new Profile(new Address("Харьков", "Зеленая", 21, 3)),
                new Profile(new Address("Киев", "Петровская", 34, 56))
        );

        List<Address> expected = List.of(
                new Address("Киев", "Петровская", 34, 56),
                new Address("Кривой Рог", "Малиновая", 2, 21),
                new Address("Харьков", "Зеленая", 21, 3)

        );
        Profiles profiles = new Profiles();

        List<Address> rsl = profiles.collect(prof);
        assertThat(rsl, is(expected));
    }
}