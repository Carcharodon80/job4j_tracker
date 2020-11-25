package ru.job4j.tracker;

public class TrackerSingleton4 {
    public TrackerSingleton4() {
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

}
