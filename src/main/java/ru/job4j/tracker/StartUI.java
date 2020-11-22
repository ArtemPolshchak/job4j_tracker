package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item " + name + " added");
    }

    public static void findAllItems(Tracker tracker ) {
        System.out.println("=== Show all items ===");
        Item[] item = tracker.findAll();
        for (int i = 0; i < item.length; i++) {
            System.out.println("id " + item[i].getId() + " name " + item[i].getName());
            //System.out.println(Arrays.toString(tracker.findAll(item)));
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = Integer.valueOf(input.askStr("enter Id"));
        Item firstItem = tracker.findById(id);
        tracker.findById(id);
        String name = input.askStr("enter name");
        Item item = new Item(name);

        if (tracker.replace(id, item)) {
            tracker.replace(id, item);
            System.out.println("replace item " + firstItem.getName() + " to " + item.getName());
        } else {
            System.out.println("This id does not exist, please enter an existing id");
        }

    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item === ");
        int id = Integer.valueOf(input.askStr("enter Id"));
        if (tracker.delete(id)) {
            System.out.println("item deleted");
        } else {
            System.out.println("This id does not exist, please enter an existing id");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        int id = Integer.valueOf(input.askStr("enter Id"));
        Item item = tracker.findById(id);
        System.out.println("Founded item: " + item.getName());
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name = input.askStr("enter Name of ID");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.println("Error, we can`t find item");
        } else {
            for (int i = 0; i < item.length; i++) {
                System.out.println("id " + item[i].getId() + " name " + item[i].getName());
            }
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {

            this.showMenu();

            int select = Integer.valueOf(input.askStr("Select: "));

            if(select == 0) {

                StartUI.createItem(input, tracker);

            } else if (select == 1) {

               StartUI.findAllItems(tracker);

            } else if (select == 2) {

                StartUI.replaceItem(input, tracker);

            } else if (select == 3) {

               StartUI.deleteItem(input, tracker);

            } else if (select == 4) {

                StartUI.findItemById(input, tracker);

            } else if (select == 5) {

                StartUI.findItemByName(input, tracker);

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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);


       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
       // String currentDateTime = item.getCreated().format(formatter);
        //System.out.println(currentDateTime);

        //System.out.println(item.toString());
        //System.out.println(tracker.findById(item.getId()));
       // System.out.println(Arrays.toString(tracker.findByName("firstOne")));


    }
}