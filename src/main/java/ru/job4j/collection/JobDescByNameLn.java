package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByNameLn implements Comparator<Job> {
        //компаратор по убыванию сравнивает количество символов в имени.
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getName().length(), o1.getName().length());
    }
}
