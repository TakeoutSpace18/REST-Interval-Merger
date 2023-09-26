package com.github.takeoutspace18.RestIntervalMerger.service;

import java.util.List;
import java.util.Optional;

public interface IntervalsService {
    void mergeLetterIntervals(List<List<String>> intervals);
    void mergeDigitIntervals(List<List<Integer>> intervals);
    Optional<List<String>> getMinLetterInterval();
    Optional<List<Integer>> getMinDigitInterval();
}
