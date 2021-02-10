package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftArray = left.split("\\.");
        String[] rightArray = right.split("\\.");
        rsl = Integer.compare(Integer.parseInt(leftArray[0]), Integer.parseInt(rightArray[0]));
        return rsl;
    }
}
