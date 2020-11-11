package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 trackerSingleton1) {
        int id = input.askInt("Введите id заявки: ");
        Item item = trackerSingleton1.tracker.findById(id);
        if (item != null) {
            out.println(item.toString());
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
