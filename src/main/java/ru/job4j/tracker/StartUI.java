package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                select0(scanner, tracker);
            } else if (select == 1) {
                select1(tracker);
            } else if (select == 2) {
                select2(scanner, tracker);
            } else if (select == 3) {
                select3(scanner, tracker);
            } else if (select == 4) {
                select4(scanner, tracker);
            } else if (select == 5) {
                select5(scanner, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private static void select0(Scanner scanner, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println();
    }

    private static void select1(Tracker tracker) {
        System.out.println("=== Show All Item ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void select2(Scanner scanner, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        System.out.println("Введите ID заявки, которую необходимо заменить: ");
        String idOld = scanner.nextLine();
        System.out.println("Введите ID заявки, на которую необходимо заменить: ");
        String idNew = scanner.nextLine();
        if (tracker.replace(idNew, tracker.findById(idOld)) == null) {
            System.out.println("Произошла ошибка, заявка не отредактировалась");
            System.out.println();
            return;
        }
        System.out.println("Заявка отредактирована");
        System.out.println();
    }

    private static void select3(Scanner scanner, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        System.out.println("Enter ID item: ");
        String id = scanner.nextLine();
        if (tracker.delete(id) == null) {
            System.out.println("Произошла ошибка, заявка не удалилась");
            System.out.println();
            return;
        }
        System.out.println("Заявка удалена");
        System.out.println();
    }

    private static void select4(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        System.out.println("Enter ID item: ");
        String id = scanner.nextLine();
        if (tracker.findById(id) == null) {
            System.out.println("Заявки с данным ID не найдено");
            System.out.println();
            return;
        }
        System.out.println(tracker.findById(id));
        System.out.println();
    }

    private static void select5(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find Items by Name ====");
        System.out.println("Enter Name item: ");
        String nameItem = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}