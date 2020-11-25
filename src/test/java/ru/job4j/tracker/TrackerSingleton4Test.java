package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrackerSingleton4Test {
    @Test
    public void whenSingleton() {
        Tracker one = TrackerSingleton4.getInstance();
        Tracker two = TrackerSingleton4.getInstance();
        assertSame(one, two);
    }

}