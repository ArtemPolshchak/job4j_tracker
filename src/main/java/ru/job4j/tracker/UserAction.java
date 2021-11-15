package ru.job4j.tracker;

import java.awt.*;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
