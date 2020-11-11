package ru.job4j.tracker;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 trackerSingleton1) {
        out.println("All items:");
        Item[] items = trackerSingleton1.tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        return true;
    }
}
