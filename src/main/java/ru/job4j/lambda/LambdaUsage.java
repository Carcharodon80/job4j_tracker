package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2.2. Лямбда блок [#340668]
 */

public class LambdaUsage {
    /**
     * Сортирует строки по убыванию + выводит отладочную информацию
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zzz", "abc", "bit", "bcc");
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return right.compareTo(left);
        };
        list.sort(comparator);
        System.out.println(list);

    }
}
