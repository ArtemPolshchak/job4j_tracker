package ru.job4j.tracker;

public class Exit implements UserAction {
    private final Output out;
    private boolean run = true;

    public Exit(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
            run = false;
        return run;
    }
}
