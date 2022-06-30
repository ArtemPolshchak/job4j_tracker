package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        store.add(item);
        out.println("Item successfully added");
        return true;
    }
}
