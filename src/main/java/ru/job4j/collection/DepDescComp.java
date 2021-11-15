package ru.job4j.collection;

import java.util.Comparator;

/**
 * DepDescComp
 */

public class DepDescComp implements Comparator<String> {
    /**
     * Method compare - character-by-character string comparison
     * @param o1 non-null String to compare
     * @param o2 non-null String to compare
     * @return in the value = 0, when both string arguments are equals
     *          int value -1, when the furst string is less than the second sting argument
     *          int value 1, when the first string is greater than the second string argument
     */

    @Override
    public int compare(String o1, String o2) {

        String[] first = o1.split("/");
        String[] second = o2.split("/");

       int  rsl = second[0].compareTo(first[0]);
        if (rsl == 0) {
            return o1.compareTo(o2);
        }
        return rsl;

    }
}
