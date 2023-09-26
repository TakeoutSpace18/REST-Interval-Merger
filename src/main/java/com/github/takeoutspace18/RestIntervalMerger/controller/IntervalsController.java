package com.github.takeoutspace18.RestIntervalMerger.controller;

import com.github.takeoutspace18.RestIntervalMerger.service.IntervalsService;
import com.github.takeoutspace18.RestIntervalMerger.utils.IntervalKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/intervals", produces = APPLICATION_JSON_VALUE)
public class IntervalsController {
    @Autowired
    private IntervalsService intervalsService;

    @SuppressWarnings("unchecked")
    @PostMapping(value = "merge")
    public ResponseEntity<Void> merge(@RequestParam IntervalKind kind, @RequestBody Object intervals) {
        switch (kind) {
            case digits -> {
                intervalsService.mergeDigitIntervals((List<List<Integer>>)intervals);
            }
            case letters -> {
                intervalsService.mergeLetterIntervals((List<List<String>>)intervals);
            }
            default -> throw new IllegalStateException("Unexpected value: " + kind);
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "min")
    public ResponseEntity<?> min(@RequestParam IntervalKind kind) {
        Optional<?> foundInterval;
        switch (kind) {
            case digits -> {
                foundInterval = intervalsService.getMinDigitInterval();
            }
            case letters -> {
                foundInterval = intervalsService.getMinLetterInterval();
            }
            default -> throw new IllegalStateException("Unexpected value: " + kind);
        }
        if (foundInterval.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(foundInterval.get());
    }
}
