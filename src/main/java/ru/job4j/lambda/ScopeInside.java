package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * 4. Зона видимости в лямбда-выражениях и исключения [#340665]
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int temp = total;
            total = add(
                    () -> temp + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
