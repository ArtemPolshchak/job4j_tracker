
package ru.job4j.tracker.items;

import ru.job4j.tracker.model.Item;

public enum TrackerSingle {
    INSTANCE;

    public Item add(Item model) {

        return model;
    }

    public static void main(String[] args) {
        TrackerSingle trackerSingle = TrackerSingle.INSTANCE;
    }
}
