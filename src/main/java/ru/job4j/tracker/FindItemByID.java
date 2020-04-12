package ru.job4j.tracker;

public class FindItemByID implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item: ");
        if (tracker.findById(id) == null) {
            System.out.println("Заявки с данным ID не найдено");
            System.out.println();
            return true;
        }
        System.out.println(tracker.findById(id));
        System.out.println();
        return true;
    }
}
