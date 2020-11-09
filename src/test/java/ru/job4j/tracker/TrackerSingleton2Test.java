package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleton2Test {
    @Test
    public void whenSingleton() {
        TrackerSingleton2 one = TrackerSingleton2.getInstance();
        TrackerSingleton2 two = TrackerSingleton2.getInstance();
        assertThat(one == two, is(true));
    }
}