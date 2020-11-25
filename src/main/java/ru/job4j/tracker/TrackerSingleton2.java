package ru.job4j.tracker;

public class TrackerSingleton2 {
    private static Tracker instance = new Tracker();

    private TrackerSingleton2() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
