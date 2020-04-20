package ru.job4j.tracker;

public class ShowAllItem implements UserAction {
    @Override
    public String name() {
        return "=== Show All Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (int i = 0; i < tracker.findAll().size(); i++) {
            System.out.println(tracker.findAll().get(i));
        }
        System.out.println();
        return true;
    }
}
