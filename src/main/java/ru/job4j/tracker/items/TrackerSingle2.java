package ru.job4j.tracker.items;

import ru.job4j.tracker.Item;

public class TrackerSingle2 {
    private static final TrackerSingle2 INSTANCE = new TrackerSingle2();

    private TrackerSingle2() {

    }

    private static TrackerSingle2 getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
    }
}
