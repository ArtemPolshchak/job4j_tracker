package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    private final Output out;

    public ConsoleInput(Output out) {
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {

        return Integer.parseInt(askStr(question));
    }

    @Override
    public int askInt(String question, int max) {
        int select = askInt(question);
        if (select < 0 || select >= max) {
            throw new IllegalStateException(
                    String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}
