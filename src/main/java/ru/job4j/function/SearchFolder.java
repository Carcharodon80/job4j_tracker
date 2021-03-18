package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 2.0. Встроенные функциональные интерфейсы. [#340669]
 */
public class SearchFolder {

    /**
     * Вызов Predicate.test с разной реализацией(см.тест), типа как паттерн Стратегия
     * @param list
     * @param pred
     * @return
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}
