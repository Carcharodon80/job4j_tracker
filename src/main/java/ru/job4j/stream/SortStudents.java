package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 4. Преобразование List в Map. [#340679]
 */
public class SortStudents {
    public Map<String, Student> sortedStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname, e -> e, (f, s) -> f));
    }
}
