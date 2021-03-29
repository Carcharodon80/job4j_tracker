package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0. Stream API [#340675]
 */
public class FilterIntStream {
    /**
     * С помощью Stream отобрать положительные числа
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 80, 900, -50, -6, 0, 8, -9);
        List<Integer> result = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(result);
    }
}
