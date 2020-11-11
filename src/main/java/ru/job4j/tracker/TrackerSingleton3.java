package ru.job4j.tracker;

public class TrackerSingleton3 {
    private static final TrackerSingleton3 INSTANCE = new TrackerSingleton3();
    Tracker tracker = new Tracker();

    public TrackerSingleton3() {
    }

    public static TrackerSingleton3 getINSTANCE() {
        return INSTANCE;
    }

}
