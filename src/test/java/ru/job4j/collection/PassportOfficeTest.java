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
        Citizen citizen2 = new Citizen("33333", "Petr Arstntev");
        Citizen citizen3 = new Citizen("11111", "Petr Arstntev");
        Citizen citizen4 = new Citizen("2f44a", "Petr Arstntev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        office.add(citizen2);
        office.add(citizen3);
        office.add(citizen4);
        assertThat(office.toString(), is("{citizens={2f44a=ru.job4j.collection.Citizen@2efbf0c, 33333=ru.job4j.collection.Citizen@2e6a392, 11111=ru.job4j.collection.Citizen@2c98410}}"));
    }






}