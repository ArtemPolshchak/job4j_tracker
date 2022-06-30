package ru.job4j.tracker.items;

import ru.job4j.tracker.model.Item;

public class TrackerSingle3 {
    private TrackerSingle3() {

    }

    public static TrackerSingle3 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    }

    public static void main(String[] args) {
        TrackerSingle3 tracker =  TrackerSingle3.getInstance();
    }
}
