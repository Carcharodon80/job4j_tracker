package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSingleton3Test {
    @Test
    public void whenSingleton() {
        TrackerSingleton3 one = TrackerSingleton3.getINSTANCE();
        TrackerSingleton3 two = TrackerSingleton3.getINSTANCE();
        assertThat(one == two, is(true));
    }

}