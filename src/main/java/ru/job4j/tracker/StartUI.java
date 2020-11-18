package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if(select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                System.out.println("Item " + name + " added");
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] item = tracker.findAll();
                for (int i = 0; i < item.length; i++) {
                    System.out.println("id " + item[i].getId() + " name " + item[i].getName());
                }
                //System.out.println(Arrays.toString(tracker.findAll(item)));
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = Integer.valueOf(scanner.nextLine());
                Item firstItem = tracker.findById(id);
                tracker.findById(id);
                String name = scanner.nextLine();
                Item item = new Item(name);

                if (tracker.replace(id, item)) {
                    tracker.replace(id, item);
                    System.out.println("replace item " + firstItem.getName() + " to " + item.getName());
                } else {
                    System.out.println("This id does not exist, please enter an existing id");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item === ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("item deleted");
                } else {
                    System.out.println("This id does not exist, please enter an existing id");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                System.out.println("Founded item: " + item.getName());
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length == 0) {
                    System.out.println("Error, we can`t find item");
                } else {
                    for (int i = 0; i < item.length; i++) {
                        System.out.println("id " + item[i].getId() + " name " + item[i].getName());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {

        //Tracker tracker1 = new Tracker();
        //item.setName("firstOne");
       // tracker1.add(item);

        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);

       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
       // String currentDateTime = item.getCreated().format(formatter);
        //System.out.println(currentDateTime);

        //System.out.println(item.toString());
        //System.out.println(tracker.findById(item.getId()));
       // System.out.println(Arrays.toString(tracker.findByName("firstOne")));


    }
}