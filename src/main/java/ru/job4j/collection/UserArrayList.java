package ru.job4j.collection;

import java.util.ArrayList;

public class UserArrayList {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Petr");
        list.add("Ivan");
        list.add("Stepan");
        for (Object names : list) {
            System.out.println(names);
        }
    }
}
