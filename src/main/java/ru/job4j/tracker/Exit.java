package ru.job4j.tracker;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, TrackerSingleton1 trackerSingleton1) {
        return false;
    }
}
