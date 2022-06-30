package ru.job4j.tracker.sort;

import ru.job4j.tracker.model.Item;

import java.util.Comparator;

public class SortByNameItem implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
