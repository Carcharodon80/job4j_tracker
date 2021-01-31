package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

public class NameDecComparatorTest {
    @Test
    public void whenBreakAndFix() {
        Comparator<Job> comparator = new NameDecComparator();
        int rsl = comparator.compare(new Job("Break", 31), new Job("Fix", 89));
        assertThat(rsl, greaterThan(0));
    }

}