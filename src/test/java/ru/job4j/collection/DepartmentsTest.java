package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 2. Отсортировать департаменты [#340828]
 */
public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = Arrays.asList("k1/sk1", "k2/sk1/ssk2");
        List<String> expect = Arrays.asList("k1", "k1/sk1", "k2", "k2/sk1", "k2/sk1/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = Arrays.asList("k1", "k1/sk1");
        List<String> expect = Arrays.asList("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void sortAsc() {
        List<String> input = Arrays.asList("k1/sk1", "k1/sk2", "k1/sk1/ssk1", "k1/sk1/ssk2",
                "k2", "k2/sk1/ssk1", "k2/sk1/ssk2");
        List<String> expected = Arrays.asList("k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2",
                "k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2");
        List<String> result = Departments.fillGaps(input);
        result.sort(Comparator.naturalOrder());
        assertThat(expected, is(result));
    }

    @Test
    public void sortDesc() {
        List<String> input = Arrays.asList("k1/sk1", "k1/sk2", "k1/sk1/ssk1", "k1/sk1/ssk2",
                "k2", "k2/sk1/ssk1", "k2/sk1/ssk2");
        List<String> expected = Arrays.asList("k2", "k2/sk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1", "k1/sk1", "k1/sk1/ssk1", "k1/sk1/ssk2", "k1/sk2");
        List<String> result = Departments.fillGaps(input);
        result.sort(new DepDescComp());
        assertThat(expected, is(result));
    }


}