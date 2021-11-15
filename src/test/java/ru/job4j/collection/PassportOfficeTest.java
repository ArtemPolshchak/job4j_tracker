package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arstntev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicate() {
        Citizen citizen = new Citizen("11111", "Petr Arstntev");
        Citizen citizen1 = new Citizen("11111", "Petr Arstntev");
        PassportOffice office = new PassportOffice();

        assertThat(office.add(citizen), is(true));
        assertThat(office.add(citizen1), is(false));
    }
}