package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Artem.polschak@gmail.com on 14.02.2021.
 * @project job4j_tracker
 */

public class CountingMethod {

    public static class Company {

        private String name;

        public Company(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Worker {

        private int age;

        private Company company;

        public Worker(int age, Company company) {
            this.age = age;
            this.company = company;
        }

        public int getAge() {
            return age;
        }

        public Company getCompany() {
            return company;
        }

        @Override
        public String toString() {
            return "Worker{" + "age=" + age
                    + ", company=" + company + '}';
        }
    }

    public static Map<String, Long> groupAndCount(List<Worker> workers) {

    return null;
    }

}
