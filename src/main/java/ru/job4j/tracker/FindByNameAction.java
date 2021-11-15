package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("enter Name of Item");
        List<Item> item = tracker.findByName(name);

        if (item.size() == 0) {
            out.println("Error, we can`t find item");
        } else {
            for (Item value : item) {

                out.println(value.getName());
            }
        }
        return true;
    }
}
