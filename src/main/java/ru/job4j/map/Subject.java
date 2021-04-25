package ru.job4j.map;

import java.util.Objects;

/**
 * 3. Optional в банковских переводах. [#340689]
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subject subject = (Subject) o;
        return Objects.equals(name, subject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
