package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Console;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Enter select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("wrong input, you can select: 0.. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }

    }

    public static void main(String[] args) {
        Output output = new Console();
        Input input = new Validate(output, new ru.job4j.tracker.input.Console(output));

        try (SqlTracker tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> actions = List.of(
                    new Create(output),
                    new Replace(output),
                    new Delete(output),
                    new FindAll(output),
                    new FindById(output),
                    new FindByName(output),
                    new Exit(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 }