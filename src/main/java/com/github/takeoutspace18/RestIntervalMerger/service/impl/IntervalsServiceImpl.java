package com.github.takeoutspace18.RestIntervalMerger.service.impl;

import com.github.takeoutspace18.RestIntervalMerger.repository.DigitIntervalsRepository;
import com.github.takeoutspace18.RestIntervalMerger.repository.LetterIntervalsRepository;
import com.github.takeoutspace18.RestIntervalMerger.repository.entity.DigitIntervals;
import com.github.takeoutspace18.RestIntervalMerger.repository.entity.LetterIntervals;
import com.github.takeoutspace18.RestIntervalMerger.service.IntervalMerger;
import com.github.takeoutspace18.RestIntervalMerger.service.IntervalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervalsServiceImpl implements IntervalsService {

    @Autowired
    private DigitIntervalsRepository digitIntervalsRepository;
    @Autowired
    private LetterIntervalsRepository letterIntervalsRepository;

    @Override
    public void mergeLetterIntervals(List<List<String>> intervals) {
        for (List<String> interval : IntervalMerger.merge(intervals)) {
            LetterIntervals entity = new LetterIntervals(interval.get(0), interval.get(1));
            letterIntervalsRepository.save(entity);
        }
    }

    @Override
    public void mergeDigitIntervals(List<List<Integer>> intervals) {
        for (List<Integer> interval : IntervalMerger.merge(intervals)) {
            DigitIntervals entity = new DigitIntervals(interval.get(0), interval.get(1));
            digitIntervalsRepository.save(entity);
        }
    }

    @Override
    public Optional<List<String>> getMinLetterInterval() {
        Optional<LetterIntervals> foundEntity = letterIntervalsRepository.findMinInterval();
        return foundEntity.map(entity -> List.of(entity.getInterval_start(), entity.getInterval_stop()));
    }

    @Override
    public Optional<List<Integer>> getMinDigitInterval() {
        Optional<DigitIntervals> foundEntity = digitIntervalsRepository.findMinInterval();
        return foundEntity.map(entity -> List.of(entity.getInterval_start(), entity.getInterval_stop()));
    }
}
