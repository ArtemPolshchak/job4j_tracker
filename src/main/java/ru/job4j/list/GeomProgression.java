package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {

        return (int) (first * (Math.pow(denominator, count) - 1) / (denominator - 1));
    }
}
