package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 4. Преобразование List в Map. [#340679]
 */
public class SortStudentsTest {

    @Test
    public void sortedStudents() {
        SortStudents sortStudents = new SortStudents();
        List<Student> input = List.of(
                new Student(40, "Surname4"),
                new Student(70, "Surname7"),
                new Student(10, "Surname1"),
                new Student(10, "Surname1"),
                new Student(70, "Surname7"),
                new Student(500, "Surname56")
        );
        Map<String, Student> rsl = sortStudents.sortedStudents(input);
        Map<String, Student> expected = Map.of(
                "Surname7", new Student(70, "Surname7"),
                "Surname4", new Student(40, "Surname4"),
                "Surname1", new Student(10, "Surname1"),
                "Surname56", new Student(500, "Surname56")
        );
        assertThat(rsl, is(expected));
    }
}