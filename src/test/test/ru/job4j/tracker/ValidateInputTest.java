package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(0));
    }

    @Test
    public void whenNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenMultipleNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "3", "-1", "5", "20"}
        );
        ValidateInput input = new ValidateInput(out, in);
        assertThat(input.askInt(""), is(2));
        assertThat(input.askInt(""), is(3));
        assertThat(input.askInt(""), is(-1));

        assertThat(input.askInt(""), is(5));
        assertThat(input.askInt(""), is(20));

    }
}