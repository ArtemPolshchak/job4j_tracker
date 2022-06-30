package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author artem.polschak@gmail.com on 24.06.2022.
 * @project job4j_tracker
 */

public final class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<Item>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> copyNames = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                copyNames.add(item);
            }
        }
        return copyNames;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}