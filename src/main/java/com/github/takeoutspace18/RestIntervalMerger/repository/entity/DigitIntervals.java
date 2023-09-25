package com.github.takeoutspace18.RestIntervalMerger.repository.entity;

import com.github.takeoutspace18.RestIntervalMerger.repository.entity.generic.Intervals;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity(name = "digit_intervals")
@NoArgsConstructor
public class DigitIntervals extends Intervals<Integer> {
    public DigitIntervals(Integer start, Integer stop) {
        super(start, stop);
    }
}
