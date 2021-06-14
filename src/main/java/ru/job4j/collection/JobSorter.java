package ru.job4j.collection;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortByNameItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(

                new Job("Fix bag", 1),
                new Job("Fix bag", 4),
                new Job("Fix bag", 2),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("X task", 0)
        );

        //по имени и по возрастанию
        Comparator<Job> cmpByNameThenLength = new JobSortByName().
                thenComparing(new JobSortByNameLn());
        Collections.sort(jobs, cmpByNameThenLength);
        System.out.println(jobs);

        System.out.println();

        //приоритету и по возрастанию
        Comparator<Job> cmpByPriorityThenLength = new JobSortByPriority().
                thenComparing(new JobSortByNameLn());

        //по имени и по убыванию
        Comparator<Job> cmpNameDescLength = new JobSortByName().
                thenComparing(new JobDescByName());

        //по приоритету и по убыванию
        Comparator<Job> cmpPriorityDescLength = new JobSortByPriority().
                thenComparing(new JobDescByPriority());

    }

    public List<Job> jobSortByName(List<Job> jobs) {
        jobs.sort(new JobSortByNameLn());
        return jobs;
    }

}

