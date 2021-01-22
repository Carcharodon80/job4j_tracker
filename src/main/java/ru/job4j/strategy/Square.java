package ru.job4j.strategy;

public class Square implements Shape{
    @Override
    public String draw() {
        return ("------\n" +
                "|    |\n" +
                "|    |\n" +
                "------\n");
    }
}
