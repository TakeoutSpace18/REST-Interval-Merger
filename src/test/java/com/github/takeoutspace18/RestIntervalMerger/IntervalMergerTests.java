package com.github.takeoutspace18.RestIntervalMerger;

import com.github.takeoutspace18.RestIntervalMerger.service.IntervalMerger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class IntervalMergerTests {

    @Test
    public void mergeDigitsTest() {
        List<List<Integer>> intervals = Arrays.asList(
                Arrays.asList(2, 5),
                Arrays.asList(17, 20),
                Arrays.asList(3, 10),
                Arrays.asList(22, 24),
                Arrays.asList(30, 36),
                Arrays.asList(26, 26),
                Arrays.asList(15, 17),
                Arrays.asList(30, 33),
                Arrays.asList(9, 12)
        );

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 12),
                Arrays.asList(15, 20),
                Arrays.asList(22, 24),
                Arrays.asList(26, 26),
                Arrays.asList(30, 36)
        );

        intervals = IntervalMerger.merge(intervals);
        Assertions.assertEquals(expected, intervals);
    }

    @Test
    public void mergeLettersTest() {
        List<List<String>> intervals = Arrays.asList(
                Arrays.asList("a", "d"),
                Arrays.asList("c", "g"),
                Arrays.asList("x", "z"),
                Arrays.asList("y", "z")
        );

        List<List<String>> expected = Arrays.asList(
                Arrays.asList("a", "g"),
                Arrays.asList("x", "z")
        );

        intervals = IntervalMerger.merge(intervals);
        Assertions.assertEquals(expected, intervals);
    }
}
