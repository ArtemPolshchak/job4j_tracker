package ru.job4j.comparator;

import java.util.*;

public class SortMap {
  public static Map<Integer, String> sort(Map<Integer, String> map) {
      Map<Integer, String> list = new TreeMap<>(Comparator.reverseOrder());
      list.putAll(map);
      return list;
   }
}
