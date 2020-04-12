package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    @Override
    public String name() {
        return "=== Find Items by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameItem = input.askStr("Enter Name item: ");
        if (tracker.findByName(nameItem).length == 0) {
            System.out.println("Заявок с данным именем не найдено");
            System.out.println();
            return true;
        }
        for (Item item : tracker.findByName(nameItem)) {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
