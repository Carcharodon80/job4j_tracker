package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * EasyStream [#401629]
 */
public class EasyStream {
    private List<Integer> integerList;

    private EasyStream(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> dest = new ArrayList<>();
        for (Integer integer : integerList) {
            dest.add(fun.apply(integer));
        }
        return new EasyStream(dest);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> dest = new ArrayList<>();
        for (Integer integer : integerList) {
            if (fun.test(integer)) {
                dest.add(integer);
            }
        }
        return new EasyStream(dest);
    }

    public List<Integer> collect() {
        return List.copyOf(integerList);
    }
}