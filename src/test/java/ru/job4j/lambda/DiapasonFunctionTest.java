package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * 5. Подсчет функции в диапазоне. [#340661]
 */
public class DiapasonFunctionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapasonFunction.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = DiapasonFunction.diapason(-2, 3, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 1D, 0D, 1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionAIs2() {
        List<Double> result = DiapasonFunction.diapason(3, 5, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(8D, 16D, 32D);
        assertThat(result, is(expected));
    }

}