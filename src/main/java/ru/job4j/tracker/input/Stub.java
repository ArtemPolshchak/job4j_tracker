package ru.job4j.tracker.input;

public class Stub implements Input {

    private String[] answers;

    private int position = 0;

    public Stub(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[position++];
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
