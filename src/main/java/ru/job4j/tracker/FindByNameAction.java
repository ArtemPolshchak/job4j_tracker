package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("enter Name of Item");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.println("Error, we can`t find item");
        } else {
            for (int i = 0; i < item.length; i++) {
                System.out.println("id " + item[i].getId() + " name " + item[i].getName());
            }
        }
        return true;
    }
}
