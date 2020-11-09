package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleton4Test {
    @Test
    public void whenSingleton() {
        TrackerSingleton4 one = TrackerSingleton4.getInstance();
        TrackerSingleton4 two = TrackerSingleton4.getInstance();
        assertThat(one == two, is(true));
    }

}