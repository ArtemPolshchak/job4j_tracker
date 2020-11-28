package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        Item item = tracker.findById(id);

        if (item != null) {
            System.out.println("Founded item: " + item.getName());
        } else {
            System.out.println("Error, we can`t find item");
        }
        return true;
    }
}
