package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static ru.job4j.stream.CountingMethod.*;

/**
 * @author Artem.polschak@gmail.com on 14.02.2021.
 * @project job4j_tracker
 */

public class CountingMethodTest {

    @Test
    public void test() {
        Company c1 = new Company("Apple");
        Company c2 = new Company("Amazon");
        Company c3 = new Company("Microsoft");
        Worker w1 = new Worker(20, c1);
        Worker w2 = new Worker(25, c2);
        Worker w3 = new Worker(30, c2);
        Worker w4 = new Worker(35, c3);
        Worker w5 = new Worker(40, c3);
        Worker w6 = new Worker(45, c3);

        Map<String, Long> expect = Map.of(
                "Apple", 1L,
                "Amazon", 2L,
                "Microsoft", 3L
        );
        assertEquals(expect, CountingMethod.groupAndCount(List.of(w1, w2, w3, w4, w5, w6)));
    }

}