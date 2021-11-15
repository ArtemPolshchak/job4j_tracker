package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private final LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(int id) {
        this.id = id;
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return getId() == item.getId() && Objects.equals(getName(),
                item.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCreated());
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(id, another.id);
    }
}
