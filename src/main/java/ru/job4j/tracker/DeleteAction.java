package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        if (tracker.delete(id)) {
            out.println("item deleted");
        } else {
            out.println("This id does not exist, please enter an existing id");
        }
        return true;
    }
}
