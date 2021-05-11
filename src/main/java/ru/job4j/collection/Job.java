package ru.job4j.collection;

public class Job implements Comparable<Job> {
    private final String name;
    private final int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "работа = '" + name + '\'' +
                ", приоритет работы =" + priority +
                '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
