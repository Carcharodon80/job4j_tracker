package ru.job4j.tracker;

public enum TrackerSingleton1 {
    INSTANCE;
    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}
