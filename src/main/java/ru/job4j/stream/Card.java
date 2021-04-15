package ru.job4j.stream;

import java.util.stream.Stream;

/**
 *8. Перенос методов в Stream API [#340683]
 */
public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit1 -> Stream.of(Value.values())
                        .map(value1 -> suit1 + " " + value1))
                .forEach(System.out::println);
    }
}
