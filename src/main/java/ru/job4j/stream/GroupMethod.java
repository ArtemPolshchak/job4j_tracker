package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Artem.polschak@gmail.com on 14.02.2021.
 * @project job4j_tracker
 */
public class GroupMethod {

    public static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
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
            return getAge() == user.getAge() && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(getAge(), name);
        }
    }

    public static Map<Integer, List<User>>  groupBy(List<User> users) {

        return users.stream()
                .collect(Collectors.groupingBy(
                        User::getAge
                ));
    }
}
