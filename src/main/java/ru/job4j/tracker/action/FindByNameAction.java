package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

/**
 * @author artem.polschak@gmail.com on 24.06.2022.
 * @project job4j_tracker
 */

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
    public boolean execute(Input input, Store store) {
        String name = input.askStr("Enter name: ");
        List<Item> item = store.findByName(name);

        if (item.size() == 0) {
            out.println("Error, we can`t find item");
        } else {
            for (Item value : item) {

                out.println(value.toString());
            }
        }
        return true;
    }
}
