package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("enter Id"));
        String name = input.askStr("enter name");
        Item item = new Item(name);

        if (tracker.replace(id, item)) {
            out.println("replace item " + item.getName() + " to " + item.getName());
        } else {
            out.println("This id does not exist, please enter an existing id");
        }
        return true;
    }
}
