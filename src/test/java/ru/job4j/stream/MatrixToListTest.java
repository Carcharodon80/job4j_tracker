package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 5. Преобразование матрицы чисел в список чисел. [#340680]
 */
public class MatrixToListTest {
    @Test
    public void testMatrixToList() {
        Integer[][] input = new Integer[][] {{1, 2}, {3, 4}, {6, 5}};
        List<Integer> result = new MatrixToList().transformMatrixToList(input);
        List<Integer> expected = List.of(1, 2, 3, 4, 6, 5);
        assertThat(result, is(expected));
    }
}