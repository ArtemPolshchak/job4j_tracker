package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item === ";
    }

    @Override
    public boolean execute(Input input, Store store) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (store.delete(id)) {
            out.println("Item is successfully deleted!");
        } else {
            out.println("Wrong id!");
        }
        return true;
    }
}
