package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 tracker) {
        int id = input.askInt("Введите номер заявки: ");
        if (tracker.tracker.delete(id)) {
            out.println("Заявка удалена");
        } else {
            out.println("Ошибка! Заявки с таким id не найдено");
        }
        return true;
    }
}
