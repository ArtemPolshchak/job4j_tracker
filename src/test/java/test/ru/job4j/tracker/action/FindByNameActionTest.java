package test.ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import static org.mockito.Mockito.mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class FindByNameActionTest {
    @Test
    public void whenItemWasFindByNameActionSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Finding item");
        tracker.add(item);
        FindByNameAction findAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Finding item");

        findAction.execute(input, tracker);

        assertThat(output.toString().trim()).isEqualTo(item.toString());

    }

    @Test
    public void whenItemWasFindByNameActionNotSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Finding item"));

        FindByNameAction findAction = new FindByNameAction(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Nonexistent item");

        findAction.execute(input, tracker);

        assertThat(output.toString().trim()).isEqualTo("Error, we can`t find item");
    }
}