package ru.job4j.tracker;

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
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            out.println("Error, we can`t find item");
        } else {
            for (int i = 0; i < item.length; i++) {
               // out.println("Item id=" + item[i].getId() + " name=" + item[i].getName());
                out.println(item[i].getName());
            }
        }
        return true;
    }
}
