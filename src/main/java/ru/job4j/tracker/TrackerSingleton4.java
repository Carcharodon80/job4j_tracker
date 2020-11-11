package ru.job4j.tracker;

public class TrackerSingleton4 {
    Tracker tracker = new Tracker();

    public TrackerSingleton4() {
    }

    private static final class Holder {
        private static final TrackerSingleton4 INSTANCE = new TrackerSingleton4();
    }

    public static TrackerSingleton4 getInstance() {
        return Holder.INSTANCE;
    }

}
