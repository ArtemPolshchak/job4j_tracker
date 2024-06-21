package test.ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Console;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;
import ru.job4j.tracker.store.MemTracker;

import java.util.Arrays;
import java.util.Objects;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {

    @Test
    public void findAllAction() {
        Output output = new Stub();
        MemTracker memTracker = new MemTracker();
        String is = System.lineSeparator();

        Item item1 = new Item();
        item1.setName("Item name1");

        Item item2 = new Item();
        item2.setName("Item name2");

        memTracker.add(item1);
        memTracker.add(item2);

        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(output.toString(),
                is("Menu." + is + "0. === Show all items ==="
                        + is + "1. Exit" + is + item1 + is + item2 + is
                        + "Menu." + is + "0. === Show all items ===" + is + "1. Exit" + is));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"100", "0" }
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(out.toString(), is(String.format(
                "Menu.%n"
                        + "0. Exit%n"
                        + "wrong input, you can select: 0.. 0%n"
                        + "Menu.%n"
                        + "0. Exit%n"
        )));
    }

    @Test
    public void whenCreateItem() {
        Output output = new Console();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(memTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new Console();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        UserAction[] actions = {
            new Replace(output),
            new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(Objects.requireNonNull(memTracker.findById(item.getId())).getName(),
                is(replacedName));

    }

    @Test
    public void whenDeleteItem() {
        Output output = new Console();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new Delete(output),
                new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, memTracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void findByNameAction() {
        Output output = new Stub();
        MemTracker memTracker = new MemTracker();
        String is = System.lineSeparator();
        Item item = memTracker.add(new Item("ONEONE"));
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", "ONEONE", "1"}
        );
        UserAction[] actions = {
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(output.toString(),
                is("Menu." + is + "0. === Find items by name ==="
                        + is + "1. Exit" + is + item
                        + is + "Menu." + is + "0. === Find items by name ==="
                        + is + "1. Exit" + is));
    }

    @Test
    public void findByIdAction() {
        Output output = new Stub();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Item name"));
        String is = System.lineSeparator();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(in, memTracker, Arrays.asList(actions));
        assertThat(output.toString(), is("Menu."
                + is + "0. === Find item by id ===" + is
                + "1. Exit" + is + "Founded item: " + item
                + is + "Menu." + is + "0. === Find item by id ===" + is + "1. Exit" + is));
    }
}