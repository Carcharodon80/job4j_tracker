package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Проверить две строчки на идентичность.
 * Даны две строки. Нужно проверить, что вторая строка получилась
 * методом перестановок символов в первой строке.
 */
public class FreezeStr {
    //берем символы из строк и кладем в карту (значение - количество
    //символа в строке), затем сравниваем карты
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        if (left.length() != right.length()) {
            rsl = false;
        } else {
            Map<Character, Integer> symbolsLeft = new HashMap<>();
            Map<Character, Integer> symbolsRight = new HashMap<>();
            for (int i = 0; i < left.length(); i++) {
                Character charLeft = left.charAt(i);
                if (symbolsLeft.containsKey(charLeft)) {
                    symbolsLeft.put(charLeft, symbolsLeft.get(charLeft) + 1);
                } else {
                    symbolsLeft.put(charLeft, 1);
                }
                Character charRight = right.charAt(i);
                if (symbolsRight.containsKey(charRight)) {
                    symbolsRight.put(charRight, symbolsRight.get(charRight) + 1);
                } else {
                    symbolsRight.put(charRight, 1);
                }
            }
            if (!symbolsLeft.equals(symbolsRight)) {
                return false;
            }
        }
        return rsl;
    }
}