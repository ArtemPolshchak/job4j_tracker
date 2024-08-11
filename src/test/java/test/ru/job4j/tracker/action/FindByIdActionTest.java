package test.ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindByIdAction;
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

class FindByIdActionTest {

    @Test
    public void whenItemWasFindByIdActionSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Finding item"));
        FindByIdAction findAction = new FindByIdAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        findAction.execute(input, tracker);

        assertThat(output.toString().trim()).isEqualTo("Founded item: " + tracker.findById(1));

    }

    @Test
    public void whenItemWasFindByIdActionNotSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Finding item"));
        FindByIdAction findAction = new FindByIdAction(output);

        Input input = mock(Input.class);

        findAction.execute(input, tracker);

        assertThat(output.toString().trim()).isEqualTo("Wrong id! Not found");

    }
}