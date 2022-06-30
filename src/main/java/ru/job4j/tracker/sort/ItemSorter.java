package ru.job4j.tracker.sort;

import ru.job4j.tracker.model.Item;

import java.util.Collections;
import java.util.List;

public class ItemSorter {

    public List<Item> itemSortByName(List<Item> items) {
        items.sort(new SortByNameItem());
        return items;
    }

    public List<Item> itemReverseSortByName(List<Item> items) {
        items.sort(new SortReverseByName());
        return items;
    }

    public List<Item> itemSortByID(List<Item> items) {
        Collections.sort(items);
        return items;
    }

    public List<Item> itemReverseSortByID(List<Item> items) {
        items.sort(Collections.reverseOrder());
        return items;
    }
}
