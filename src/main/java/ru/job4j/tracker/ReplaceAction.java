package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 trackerSingleton1) {
        int id = input.askInt("Введите id заявки: ");
        String newName = input.askStr("Введите новое имя: ");
        Item newItem = new Item(newName);
        if (trackerSingleton1.tracker.replace(id, newItem)) {
            out.println("Замена произведена успешно");
        } else {
            out.println("Ошибка! Заявки с таким id не найдено");
        }
        return true;
    }
}
