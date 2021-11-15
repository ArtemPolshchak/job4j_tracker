package ru.job4j.set;

import java.util.*;

public class UniqueName {
    public static int collectUniqueName(List<User> users) {
        HashSet<String> list = new HashSet<>();
        for (User user : users) {
            list.add(user.getName());
        }
        return list.size();
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id && Objects.equals(getName(), user.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, getName());
        }
    }
}
