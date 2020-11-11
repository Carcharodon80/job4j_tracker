package ru.job4j.tracker;

public enum TrackerSingleton1 {
    INSTANCE;
    Tracker tracker = new Tracker();
}
