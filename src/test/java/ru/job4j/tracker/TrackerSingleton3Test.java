package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingleton3Test {
    @Test
    public void whenSingleton() {
        Tracker one = TrackerSingleton3.getINSTANCE();
        Tracker two = TrackerSingleton3.getINSTANCE();
        assertSame(one,  two);
    }

}