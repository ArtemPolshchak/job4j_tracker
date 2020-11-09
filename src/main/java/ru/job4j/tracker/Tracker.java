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
        int count = 0;
        Item[] notNullItems = new Item[size];
        for (int i = 0; i < size; i++) {

            if (items[i] != null) {
                notNullItems[count] = items[i];
                count++;
            }
        }
        notNullItems = Arrays.copyOf(notNullItems, count);
        return notNullItems;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
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
        return copyNames;

    }
}