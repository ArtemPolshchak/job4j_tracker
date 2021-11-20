package ru.job4j.comparator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysSortWithObjectTest {
    @Test
    public void test() {
        String[] input = {"a", "b", "c"};
        String[] result = ArraysSortWithObject.sort(input);
        String[] expect = {"c", "b", "a"};
        Assert.assertEquals(expect, result);
    }
}