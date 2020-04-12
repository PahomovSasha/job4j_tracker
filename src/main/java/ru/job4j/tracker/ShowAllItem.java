package ru.job4j.tracker;

public class ShowAllItem implements UserAction {
    @Override
    public String name() {
        return "=== Show All Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        System.out.println();
        return true;
    }
}
