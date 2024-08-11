package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id = input.askInt("Enter id: ");
        Item item = store.findById(id);

        if (item != null) {
            out.println("Founded item: " + item);
        } else {
            out.println("Wrong id! Not found");
        }
        return true;
    }
}
