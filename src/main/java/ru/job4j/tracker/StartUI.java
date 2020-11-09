package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        Tracker tracker = new Tracker();
        item.setName("firstOne");
        tracker.add(item);

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
       // String currentDateTime = item.getCreated().format(formatter);
        //System.out.println(currentDateTime);

        System.out.println(item.toString());
        System.out.println(tracker.findById(item.getId()));
        System.out.println(Arrays.toString(tracker.findByName("firstOne")));


    }
}