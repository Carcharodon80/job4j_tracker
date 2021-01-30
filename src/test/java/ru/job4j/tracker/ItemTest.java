package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void itemNormalSortTest() {
        Comparator normalComparator = new ItemByNameNormalComparator();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item03");
        Item item4 = new Item("4");
        List<Item> items = Arrays.asList(item1, item2, item4, item3);
        Collections.sort(items, normalComparator);
        List<Item> expected = Arrays.asList(item4, item3, item1, item2);
        assertThat(items, is(expected));
    }

    @Test
    public void itemReverseSortTest() {
        Comparator reverseComparator = new ItemByNameReverseComparator();
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Item item3 = new Item("Item03");
        Item item4 = new Item("4");
        List<Item> items = Arrays.asList(item1, item2, item4, item3);
        Collections.sort(items, reverseComparator);
        List<Item> expected = Arrays.asList(item2, item1, item3, item4);
        assertThat(items, is(expected));
    }

}