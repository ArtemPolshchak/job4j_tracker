package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        Item firstItem = tracker.findById(id);
        tracker.findById(id);
        String name = input.askStr("enter name");
        Item item = new Item(name);

        if (tracker.replace(id, item)) {
            System.out.println("replace item " + firstItem.getName() + " to " + item.getName());
        } else {
            System.out.println("This id does not exist, please enter an existing id");
        }
        return true;
    }
}
