package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PutContainsKey {

    public static Map<Integer, User> addNewElementWithoutCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();

        for (User user : list) {
            rsl.put(user.getId(), user);
        }
        return rsl;
    }

    public static Map<Integer, User> addNewElementWithCheck(List<User> list) {
        Map<Integer, User> rsl = new HashMap<>();
        for (User user : list) {
         if (!rsl.containsKey(user.getId())) {
             rsl.put(user.getId(), user);
         }
        }
        return rsl;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}