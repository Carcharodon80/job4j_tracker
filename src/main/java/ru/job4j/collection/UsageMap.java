package ru.job4j.collection;

import java.util.HashMap;
import java.util.Set;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("aaa@gmail.com", "AAA");
        map.put("bbb@mail.ru", "BBB");
        map.put("aaa@gmail.com", "CCC");
        Set<String> setKeys = map.keySet();
        for (String key : setKeys) {
            System.out.printf("Key : %s, value : %s%n", key, map.get(key));
        }
    }
}
