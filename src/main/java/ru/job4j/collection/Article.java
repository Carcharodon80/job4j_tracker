package ru.job4j.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * 1. Генератор текста
 * Задан большой текст. Из него вырезают слова и предложения.
 * Из них составляют новый текст.
 *
 * Нужно проверить, что новый текст был получен из оригинального.
 */
public class Article {
     //тексты разбиваем на слова по пробелам и знакам препинания
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Set<String> originSet = new HashSet<>();
        Set<String> lineSet = new HashSet<>();
        Collections.addAll(originSet, origin.split("[\\p{P} ]"));
        Collections.addAll(lineSet, line.split("[\\p{P} ]"));
        for (String word : lineSet) {
            if (!originSet.contains(word)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}