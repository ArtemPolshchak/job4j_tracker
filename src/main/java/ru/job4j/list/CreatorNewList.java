package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class CreatorNewList {
    public static void main(String[] args) {
        System.out.println("Создаем список с пустым конструктором.");
        List<String> first = new ArrayList<>();
        System.out.println("Добавляем 3 элемента в список.");
        first.add("one");
        first.add("two");
        first.add("three");
        System.out.println("Создаем список - в конструктор передаем коллекцию.");
        List<String> second = new ArrayList<>(first);
        System.out.println("Выводим все элементы в списке.");
        for (String s : second) {
            System.out.println(s);
        }
    }
}