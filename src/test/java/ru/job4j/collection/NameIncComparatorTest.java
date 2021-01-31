package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class NameIncComparatorTest {
    @Test
    public void whenBreakAndFix() {
        Comparator<Job> comparator = new NameIncComparator();
        int rsl = comparator.compare(new Job("Break", 31), new Job("Fix", 89));
        assertThat(rsl, lessThan(0));
    }

}