package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleton2Test {
    @Test
    public void whenSingleton() {
        Tracker one = TrackerSingleton2.getInstance();
        Tracker two = TrackerSingleton2.getInstance();
        assertSame(one, two);
    }
}