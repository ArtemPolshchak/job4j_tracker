package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int index = 0; index < persons.size(); index++) {
            if (persons.get(index).getName().equals(key)) {
                result = persons;
            } else if (persons.get(index).getSurname().equals(key)) {
                result = persons;
            } else if (persons.get(index).getPhone().equals(key)) {
                result = persons;
            } else if (persons.get(index).getAddress().equals(key)) {
                result = persons;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
