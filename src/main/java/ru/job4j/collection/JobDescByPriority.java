package ru.job4j.collection;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {
    //компаратор по убыванию, по полям приоритет
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o2.getPriority(), o1.getPriority());
    }
}