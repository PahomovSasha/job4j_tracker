package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                createNewItem(input, tracker);
            } else if (select == 1) {
                showAllItem(tracker);
            } else if (select == 2) {
                editItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemByID(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private static void createNewItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println();
    }

    private static void showAllItem(Tracker tracker) {
        System.out.println("=== Show All Item ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String idOld = input.askStr("Введите ID заявки, которую необходимо заменить: ");
        String nameNew = input.askStr("Введите Имя новой заявки: ");
        if (!tracker.replace(idOld, new Item(nameNew))) {
            System.out.println("Произошла ошибка, заявка не отредактировалась");
            System.out.println();
            return;
        }
        System.out.println("Заявка отредактирована");
        System.out.println();
    }

    private static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String id = input.askStr("Enter ID item: ");
        if (!tracker.delete(id)) {
            System.out.println("Произошла ошибка, заявка не удалилась");
            System.out.println();
            return;
        }
        System.out.println("Заявка удалена");
        System.out.println();
    }

    private static void findItemByID(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        String id = input.askStr("Enter ID item: ");
        if (tracker.findById(id) == null) {
            System.out.println("Заявки с данным ID не найдено");
            System.out.println();
            return;
        }
        System.out.println(tracker.findById(id));
        System.out.println();
    }

    private static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find Items by Name ====");
        String nameItem = input.askStr("Enter Name item: ");
        if (tracker.findByName(nameItem).length == 0) {
            System.out.println("Заявок с данным именем не найдено");
            System.out.println();
            return;
        }
        for (Item item : tracker.findByName(nameItem)) {
            System.out.println(item);
        }
        System.out.println();
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}