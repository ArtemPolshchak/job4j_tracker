package ru.job4j.collection;

import java.util.*;

/**
 * Departments
 */

public class Departments {
    /**
     * Method fillGaps adds the missing sections of the departments
     * @param deps list<String> without null elements
     * @return ArrayList tmp
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
               start = start.equals("") ? el : (start + "/" + el);
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Method sortAsc - sorting an array with departments
     * @param orgs list<String>
     * @return sorted ArrayList
     */
    public static List<String> sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        return orgs;
    }

    /**
     * Method sortDesc - sorting an array in hierarchical descending order
     * @param orgs list<String>
     * @return sorted ArrayList
     */
    public static List<String> sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
        return orgs;
    }
}
