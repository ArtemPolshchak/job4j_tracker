package ru.job4j.collection;

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

        Comparator<Job> cmpByNameThenLength = new JobSortByName().
                thenComparing(new JobSortByNameLn());
        Collections.sort(jobs, cmpByNameThenLength);
        System.out.println(jobs);

        System.out.println();

        Comparator<Job> cmpByPriorityThenLength = new JobSortByPriority().
                thenComparing(new JobSortByNameLn());

        Comparator<Job> cmpNameDescLength = new JobSortByName().
                thenComparing(new JobDescByName());

        Comparator<Job> cmpPriorityDescLength = new JobSortByPriority().
                thenComparing(new JobDescByPriority());
    }

    public List<Job> jobSortByName(List<Job> jobs) {
        jobs.sort(new JobSortByNameLn());
        return jobs;
    }
}

