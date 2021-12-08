package ru.job4j.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobSorterTest {

    @Test
    public void whenComparatorByNameAndPriorityEquals0() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("a", 0),
                new Job("a", 0)
        );
        assertThat(rsl, equalTo(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityLessThan0() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("b", 1),
                new Job("a", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityGreaterThan0() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 5),
                new Job("Impl task", 1)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndLength() {
        Comparator<Job> cmpByNameThenLength = new JobSortByName().
                thenComparing(new JobSortByNameLn());
        int rsl = cmpByNameThenLength.compare(
                new Job("Impl task", 5),
                new Job("Fix", 6)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorPriorityThenLength() {
        Comparator<Job> cmpByPriorityThenLength = new JobSortByPriority().
                thenComparing(new JobSortByNameLn());
        int rsl = cmpByPriorityThenLength.compare(
                new Job("Impl task", 5),
                new Job("Fix", 6)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndDescName() {
        Comparator<Job> cmpNameDescLength = new JobSortByName().
                thenComparing(new JobDescByName());
        int rsl = cmpNameDescLength.compare(
                new Job("Impl task", 5),
                new Job("Fix", 6)

        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndDescPriority() {
        Comparator<Job> cmpPriorityDescLength = new JobSortByPriority().
                thenComparing(new JobDescByPriority());
        int rsl = cmpPriorityDescLength.compare(
                new Job("Impl task", 5),
                new Job("Fix", 6)

        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("a", 1),
                new Job("b", 4),
                new Job("c", 2),
                new Job("d", 0)
        );

        List<Job> res = List.of(
                new Job("d", 0),
                new Job("c", 2),
                new Job("b", 4),
                new Job("a", 1)
        );

        jobs.sort(new JobDescByName());

        assertThat(jobs, is(res));
    }

    @Test
    public void whenJobDescByNameLn() {
        List<Job> jobs = Arrays.asList(
                new Job("I", 0),
                new Job("Art", 1),
                new Job("Sort", 4),
                new Job("To", 2)

        );

        List<Job> res = List.of(

                new Job("Sort", 4),
                new Job("Art", 1),
                new Job("To", 2),
                new Job("I", 0)

        );

        jobs.sort(new JobDescByNameLn());

        assertThat(jobs, is(res));
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("a", 1),
                new Job("b", 4),
                new Job("c", 2),
                new Job("d", 0)
        );

        List<Job> res = List.of(

                new Job("b", 4),
                new Job("c", 2),
                new Job("a", 1),
                new Job("d", 0)

        );

        jobs.sort(new JobDescByPriority());

        assertThat(jobs, is(res));
    }

    @Test
    public void whenJobSortByName() {

        List<Job> jobs = Arrays.asList(
                new Job("d", 0),
                new Job("c", 2),
                new Job("b", 4),
                new Job("a", 1)
        );
        List<Job> res = List.of(
                new Job("a", 1),
                new Job("b", 4),
                new Job("c", 2),
                new Job("d", 0)
        );

        jobs.sort(new JobSortByName());

        assertThat(jobs, is(res));
    }

    @Test
    public void whenJobSortByNameLn() {
        List<Job> jobs = Arrays.asList(
                new Job("ally", 1),
                new Job("bro", 4),
                new Job("hi", 2),
                new Job("I", 0)
        );

        List<Job> res = List.of(
                new Job("I", 0),
                new Job("hi", 2),
                new Job("bro", 4),
                new Job("ally", 1)
        );

        jobs.sort(new JobSortByNameLn());

        assertThat(jobs, is(res));
    }

    @Test
    public void whenJobSortByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("a", 1),
                new Job("b", 4),
                new Job("c", 2),
                new Job("d", 0)
        );

        List<Job> res = List.of(
                new Job("d", 0),
                new Job("a", 1),
                new Job("c", 2),
                new Job("b", 4)

        );

        jobs.sort(new JobSortByPriority());

        assertThat(jobs, is(res));
    }
}