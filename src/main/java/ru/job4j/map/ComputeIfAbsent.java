package ru.job4j.map;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ComputeIfAbsent {
    public static Map<Integer, String> collectData(Map<Integer, String> names, List<User> users) {
        for (User user : users) {
            names.computeIfPresent(user.getId(), (k, v) -> user.getName());
            names.computeIfAbsent(user.getId(), key -> user.getName());
        }
        return names;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return getId() == user.getId() && Objects.equals(getName(), user.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }
}
