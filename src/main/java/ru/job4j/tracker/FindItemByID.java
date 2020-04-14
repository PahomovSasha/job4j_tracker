package ru.job4j.tracker;

public class FindItemByID implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item: ");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявки с данным ID не найдено");
            System.out.println();
            return true;
        }
        System.out.println(item);
        System.out.println();
        return true;
    }
}
