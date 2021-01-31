package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class PriorityDecComparatorTest {
    @Test
    public void when31And89() {
        Comparator<Job> comparator = new PriorityDecComparator();
        int rsl = comparator.compare(new Job("Break", 31), new Job("Fix", 89));
        assertThat(rsl, greaterThan(0));
    }
}