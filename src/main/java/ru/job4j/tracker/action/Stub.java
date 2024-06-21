package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.Store;

/**
 * @author artem.polschak on 25.06.2022.
 * @project job4j_tracker
 */
public class Stub implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub action";
    }

    @Override
    public boolean execute(Input input, Store store) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
