package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Items by Name";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 trackerSingleton1) {
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = trackerSingleton1.tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
