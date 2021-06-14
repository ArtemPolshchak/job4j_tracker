package ru.job4j.collection;

import java.util.Objects;

public class Job implements Comparable<Job> {
    private final String name;
    private final int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        Job job = (Job) o;
        return getPriority() == job.getPriority() && Objects.equals(getName(), job.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPriority());
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "работа = '" + name + '\'' + ", приоритет работы =" + priority + '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
