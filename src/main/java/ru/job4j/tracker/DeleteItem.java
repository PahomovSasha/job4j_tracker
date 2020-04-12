package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID item: ");
        if (!tracker.delete(id)) {
            System.out.println("Произошла ошибка, заявка не удалилась");
            System.out.println();
            return true;
        }
        System.out.println("Заявка удалена");
        System.out.println();
        return true;
    }
}
