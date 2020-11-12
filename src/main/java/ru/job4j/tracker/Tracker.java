package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(Item[] items) {

        return Arrays.copyOf(items, size);

    }

    public Item findById(int id) {
        int index = indexOf(id);

        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] copyNames = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                if (key.equals(items[i].getName())) {
                    copyNames[count] = items[i];
                    count ++;
                }
            }
        }
        copyNames = Arrays.copyOf(copyNames, count);
        return copyNames;

    }
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
            items[index] = item;

            return true;

    }

}