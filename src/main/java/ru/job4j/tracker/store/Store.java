package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.util.List;

/**
 * @author artem.polschak@gmail.com on 24.06.2022.
 * @project job4j_tracker
 */
public interface Store {

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll();

    List<Item> findByName(String key);

    Item findById(int id);
}
