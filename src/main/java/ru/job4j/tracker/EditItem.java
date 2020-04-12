package ru.job4j.tracker;

public class EditItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String idOld = input.askStr("Введите ID заявки, которую необходимо заменить: ");
        String nameNew = input.askStr("Введите Имя новой заявки: ");
        if (!tracker.replace(idOld, new Item(nameNew))) {
            System.out.println("Произошла ошибка, заявка не отредактировалась");
            System.out.println();
            return true;
        }
        System.out.println("Заявка отредактирована");
        System.out.println();
        return true;
    }
}
