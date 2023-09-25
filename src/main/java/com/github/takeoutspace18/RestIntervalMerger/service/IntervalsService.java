package com.github.takeoutspace18.RestIntervalMerger.service;

import java.util.List;

public interface IntervalsService {
    void mergeLetterIntervals(List<List<String>> intervals);
    void mergeDigitIntervals(List<List<Integer>> intervals);
    List<String> getMinLetterInterval();
    List<Integer> getMinDigitInterval();
}
