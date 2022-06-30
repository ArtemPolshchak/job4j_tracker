package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.sort.ItemSorter;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemSorterTest {

    @Test
    public void whenSortedItem() {
        List<Item>  items1 = Arrays.asList(
                new Item(5, "e"),
                new Item(2, "b"),
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d")
        );
        List<Item>  itemsSorted = Arrays.asList(
                new Item(1, "a"),
                new Item(2, "b"),
                new Item(3, "c"),
                new Item(4, "d"),
                new Item(5, "e")

        );
        ItemSorter sorter = new ItemSorter();
        assertThat(sorter.itemSortByName(items1), is(itemsSorted));

    }

    @Test
    public void whenReverseSortedItem() {
        List<Item>  items1 = Arrays.asList(
                new Item(5, "e"),
                new Item(2, "b"),
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d")
        );
        List<Item>  itemsSorted = Arrays.asList(
                new Item(5, "e"),
                new Item(4, "d"),
                new Item(3, "c"),
                new Item(2, "b"),
                new Item(1, "a")
        );
        ItemSorter sorter = new ItemSorter();
        assertThat(sorter.itemReverseSortByName(items1), is(itemsSorted));

    }

    @Test
    public void whenSortByIdItem() {
        List<Item>  items1 = Arrays.asList(
                new Item(5, "e"),
                new Item(2, "b"),
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d")
        );
        List<Item>  itemsSorted = Arrays.asList(
                new Item(1, "a"),
                new Item(2, "b"),
                new Item(3, "c"),
                new Item(4, "d"),
                new Item(5, "e")
        );
        ItemSorter sorter = new ItemSorter();
        assertThat(sorter.itemSortByID(items1), is(itemsSorted));

    }

    @Test
    public void whenReverseSortByIdItem() {
        List<Item>  items1 = Arrays.asList(
                new Item(5, "e"),
                new Item(2, "b"),
                new Item(1, "a"),
                new Item(3, "c"),
                new Item(4, "d")
        );
        List<Item>  itemsSorted = Arrays.asList(
                new Item(5, "e"),
                new Item(4, "d"),
                new Item(3, "c"),
                new Item(2, "b"),
                new Item(1, "a")
        );
        ItemSorter sorter = new ItemSorter();
        assertThat(sorter.itemReverseSortByID(items1), is(itemsSorted));
    }
}