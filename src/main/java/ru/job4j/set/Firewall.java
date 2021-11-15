package ru.job4j.set;

import java.util.*;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        Set<String> list = new HashSet<>(Arrays.asList(s.split(" ")));
        int sz = list.size() + words.size();
        list.addAll(words);
        if (list.size() == sz) {
            return  "Вы сделали правильный выбор!";
        } else  {
            return "Выберите другую статью...";
            }
       }
    }

