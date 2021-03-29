package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 5. Подсчет функции в диапазоне. [#340661]
 */
public class DiapasonFunction {
    /**
     * Метод возвращает значения функции в заданном диапазоне (включительно!)
     *
     * @param start
     * @param end
     * @param func  - функция, переданная в Function (см. задачу Встроенные функциональные интерфейсы)
     * @return
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (double i = start; i <= end; i++) {
            rsl.add(func.apply(i));
        }
        return rsl;
    }
}
