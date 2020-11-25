package ru.job4j.tracker;

public class TrackerSingleton3 {
    private static final Tracker INSTANCE = new Tracker();

    public TrackerSingleton3() {
    }

    public static Tracker getINSTANCE() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return INSTANCE;
    }
}
