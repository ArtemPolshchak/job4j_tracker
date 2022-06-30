package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

public interface UserAction {
    String name();

    boolean execute(Input input, Store memTracker);
}
