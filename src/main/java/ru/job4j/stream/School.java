package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 1. Фильтрация учеников [#340676]
 */
public class School {
    /**
     *
     * @param students - список студентов
     * @param predict - условие фильтрации задается в тесте
     * @return - отфильтрованные студенты
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

}
