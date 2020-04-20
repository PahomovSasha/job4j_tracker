package ru.job4j.tracker;

import java.util.ArrayList;

public class FindItemByName implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameItem = input.askStr("Enter Name item: ");
        ArrayList<Item> items = (ArrayList<Item>) tracker.findByName(nameItem);
        if (items.size() == 0) {
            System.out.println("Заявок с данным именем не найдено");
            System.out.println();
            return true;
        }
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
