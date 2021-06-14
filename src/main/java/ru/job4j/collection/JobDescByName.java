package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    //компаратор по убыванию, по полям имени
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

