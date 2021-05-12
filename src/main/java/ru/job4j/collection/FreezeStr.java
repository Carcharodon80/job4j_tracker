package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 2. Проверить две строчки на идентичность.
 * Даны две строки. Нужно проверить, что вторая строка получилась
 * методом перестановок символов в первой строке.
 */
public class FreezeStr {
    //берем символы из 1 строки и кладем в карту (значение - количество
    //символа в строке), затем сравниваем
    public static boolean eq(String left, String right) {
        boolean rsl = false;
        Map<Character, Integer> symbolsLeft = new HashMap<>();
        if (left.length() == right.length()) {
            for (int i = 0; i < left.length(); i++) {
                Character charLeft = left.charAt(i);
                if (symbolsLeft.containsKey(charLeft)) {
                    symbolsLeft.put(charLeft, symbolsLeft.get(charLeft) + 1);
                } else {
                    symbolsLeft.put(charLeft, 1);
                }
            }
        } else {
            return false;
        }
        for (int i = 0; i < right.length(); i++) {
            char currentChar = right.charAt(i);
            if (!symbolsLeft.containsKey(currentChar)) {
                return false;
            } else if (symbolsLeft.containsKey(currentChar) && symbolsLeft.get(currentChar) > 1) {
                symbolsLeft.put(currentChar, symbolsLeft.get(currentChar) - 1);
            } else {
                symbolsLeft.remove(currentChar);
            }
        }
        if (symbolsLeft.isEmpty()) {
            rsl = true;
        }

        return rsl;
    }
}