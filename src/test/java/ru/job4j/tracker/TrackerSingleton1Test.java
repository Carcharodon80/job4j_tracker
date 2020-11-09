package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleton1Test {
    @Test
    public void whenSingleton() {
        TrackerSingleton1 one = TrackerSingleton1.INSTANCE;
        TrackerSingleton1 two = TrackerSingleton1.INSTANCE;
        assertThat(one == two, is(true));
    }

}