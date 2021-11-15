package ru.job4j.map;

import java.util.*;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (Info listInfo : list) {
            map.putIfAbsent(listInfo.getCity(), 0);
        }

        for (String strFromKeySet : map.keySet()) {
            for (Info listInfo : list) {
                if (strFromKeySet.equals(listInfo.getCity())) {
                    map.computeIfPresent(strFromKeySet,
                            (key, value) -> value += listInfo.getRainfall());
                }
            }
        }
        for (String info : map.keySet()) {
            Info info1 = new Info(info, map.get(info));
            rsl.add(info1);

        }
        for (Info info : rsl) {
            System.out.println(info.toString());
        }

        return rsl;
    }

    public static void main(String[] args) {
        List<Info> list = List.of(
                new Info("Minsk", 25), new Info("Brest", 5), new Info("Grodna", 33),
                new Info("Gomel", 26), new Info("Minsk", 15), new Info("Vitebsk", 18),
                new Info("Grodna", 18), new Info("Brest", 18), new Info("Gomel", 40),
                new Info("Minsk", 55), new Info("Vitebsk", 36), new Info("Minsk", 30),
                new Info("Gomel", 15), new Info("Grodna", 15), new Info("Brest", 40)
        );
        List<Info> rsl = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (Info listInfo : list) {
            map.putIfAbsent(listInfo.getCity(), 0);
        }

        for (String strFromKeySet : map.keySet()) {
            for (Info listInfo : list) {
                if (strFromKeySet.equals(listInfo.getCity())) {
                    map.computeIfPresent(strFromKeySet, (key, value) -> value
                            += listInfo.getRainfall());
                }
            }
        }
        for (String info : map.keySet()) {
            Info info1 = new Info(info, map.get(info));
            rsl.add(info1);

        }
        for (Info info : rsl) {
            System.out.println(info.toString());
        }

    }

    public static class Info {
        private String city;
        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Info)) {
                return false;
            }
            Info info = (Info) o;
            return getRainfall() == info.getRainfall() && Objects.equals(getCity(), info.getCity());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCity(), getRainfall());
        }

        @Override
        public String toString() {
            return "Info{" + "city='" + city + '\'' + ", rainfall=" + rainfall + '}';
        }
    }

}
