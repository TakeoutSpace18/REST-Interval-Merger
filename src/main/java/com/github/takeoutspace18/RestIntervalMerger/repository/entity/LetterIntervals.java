package com.github.takeoutspace18.RestIntervalMerger.repository.entity;

import com.github.takeoutspace18.RestIntervalMerger.repository.entity.generic.Intervals;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity(name = "letter_intervals")
@NoArgsConstructor
public class LetterIntervals extends Intervals<String> {
    public LetterIntervals(String start, String stop) {
        super(start, stop);
    }
}
