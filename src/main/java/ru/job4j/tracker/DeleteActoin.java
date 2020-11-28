package ru.job4j.tracker;

public class DeleteActoin implements UserAction{
    @Override
    public String name() {
        return "=== Delete item === ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        if (tracker.delete(id)) {
            System.out.println("item deleted");
        } else {
            System.out.println("This id does not exist, please enter an existing id");
        }
        return true;
    }
}
