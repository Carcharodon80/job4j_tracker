package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            char charLeft = left.charAt(i);
            char charRight = right.charAt(i);
            if (charLeft != charRight) {
                rsl = Character.compare(charLeft, charRight);
                break;
            }
        }
        if (rsl == 0) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
