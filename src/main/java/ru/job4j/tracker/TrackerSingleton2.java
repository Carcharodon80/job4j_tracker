package ru.job4j.tracker;

public class TrackerSingleton2 {
    private static TrackerSingleton2 instance;
    Tracker tracker = new Tracker();

    private TrackerSingleton2() {
    }

    public static TrackerSingleton2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingleton2();
        }
        return instance;
    }

}
