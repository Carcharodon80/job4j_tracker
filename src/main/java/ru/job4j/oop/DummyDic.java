package ru.job4j.oop;

public class DummyDic {
    public String engToRus (String eng) {
        return "Неизвестное слово: " + eng;
    }

    public static void main(String[] args) {
        DummyDic item = new DummyDic();
        System.out.println(item.engToRus("a bus"));
    }
}
