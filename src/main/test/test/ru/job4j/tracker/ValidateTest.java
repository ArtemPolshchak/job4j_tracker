package test.ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateTest {
    @Test
    public void whenInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"one", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(0));
    }

    @Test
    public void whenNegativeNumber() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"-1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenMultipleNumber() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"2", "3", "-1", "5", "20"}
        );
        Validate input = new Validate(out, in);
        assertThat(input.askInt(""), is(2));
        assertThat(input.askInt(""), is(3));
        assertThat(input.askInt(""), is(-1));

        assertThat(input.askInt(""), is(5));
        assertThat(input.askInt(""), is(20));

    }
}