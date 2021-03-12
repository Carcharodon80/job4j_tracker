package ru.job4j.collection;

import java.util.Comparator;

/**
 * 2. Отсортировать департаменты [#340828]
 */

public class DepDescComp implements Comparator<String> {
    /**
     * Сравнивает первые элементы по убыванию, остальные по возрастанию, затем по длине
     *
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        rsl = o2Array[0].compareTo(o1Array[0]);
        int minSize = Math.min(o1Array.length, o2Array.length);
        for (int i = 1; i < minSize; i++) {
            if (rsl == 0) {
                rsl = o1Array[i].compareTo(o2Array[i]);
            }
        }
        if (rsl == 0) {
            rsl = o1Array.length - o2Array.length;
        }
        return rsl;
    }
}
