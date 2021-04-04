package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 5. Преобразование матрицы чисел в список чисел. [#340680]
 */
public class MatrixToList {
    /**
     * flatMap получает элемент потока (массив Integer[]) и преобразует его в новый поток
     * @param matrix
     * @return
     */
    public List<Integer> transformMatrixToList (Integer[][] matrix) {
        return Stream.of(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
    }
}
