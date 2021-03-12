package ru.job4j.collection;

import java.util.*;

/**
 * 2. Отсортировать департаменты [#340828]
 */
public class Departments {
    /**
     * Метод заполняет пропущенные подразделения
     * @param deps
     * @return ArrayList<String> - список подразделений
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Сортировка по возрастанию
     * @param orgs
     * @return
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Сортировка по убыванию
     * @param orgs
     * @return
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
