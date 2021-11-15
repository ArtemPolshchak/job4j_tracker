package ru.job4j.collection;

import java.util.Comparator;

public class JobSortByNameLn implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
