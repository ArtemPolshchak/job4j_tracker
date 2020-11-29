package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        Item item = tracker.findById(id);

        if (item != null) {
            out.println("Founded item: " + item.getName());
        } else {
            out.println("Error, we can`t find item");
        }
        return true;
    }
}
