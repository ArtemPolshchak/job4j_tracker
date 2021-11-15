package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        Comparator comparatorSize = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return Integer.compare(left.getSize(), right.getSize());

            }
        };

        attachments.sort(comparatorSize);
        System.out.println(attachments);

        Comparator comparatorNames = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparatorNames);
        System.out.println(attachments);
    }
}
