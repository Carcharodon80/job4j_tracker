package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> comparator = new NameIncComparator().
                thenComparing(new PriorityIncComparator());
        int rsl = comparator.compare(
                new Job("AAA", 0),
                new Job("BBB", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority2() {
        Comparator<Job> comparator = new NameIncComparator().
                thenComparing(new PriorityDecComparator());
        int rsl = comparator.compare(
                new Job("AAA", 5),
                new Job("AAA", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority3() {
        Comparator<Job> comparator = new NameIncComparator().
                thenComparing(new PriorityIncComparator());
        int rsl = comparator.compare(
                new Job("AAA", 3),
                new Job("AAA", 3)
        );
        assertThat(rsl, is(0));
    }
}