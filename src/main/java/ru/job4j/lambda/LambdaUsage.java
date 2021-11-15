package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {

        Attachment[] atts = {
                new Attachment("bimage 2", 120),
                new Attachment("eimage1 3", 21),
                new Attachment("aimage 1", 20),
                new Attachment("cimage1234 6", 50),
                new Attachment("fimage12 4", 29),
                new Attachment("dimage123 5", 23)
        };

        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getName() + " : " + right.getName());
            return right.getName().compareTo(left.getName());
        };

        Arrays.sort(atts, comparator);

        for (Attachment a : atts) {
            System.out.println(a);
        }
    }
}
