package ru.job4j.map;

import java.util.Map;
import java.util.Objects;

public class Farm {
    public static int sumLegs(Map<Animal, Integer> data) {
        int sum = 0;
        for (Animal an : data.keySet()) {
            sum += an.getLegs() * data.get(an);
        }

        return sum;
    }

    public static class Animal {
        private String  name;
        private int legs;

        public Animal(String name, int legs) {
            this.name = name;
            this.legs = legs;
        }

        public String getName() {
            return name;
        }

        public int getLegs() {
            return legs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Animal)) {
                return false;
            }
            Animal animal = (Animal) o;
            return getLegs() == animal.getLegs() && Objects.equals(getName(), animal.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getLegs());
        }
    }
}
