package com.github.takeoutspace18.RestIntervalMerger.controller;

import com.github.takeoutspace18.RestIntervalMerger.service.IntervalsService;
import com.github.takeoutspace18.RestIntervalMerger.utils.IntervalKind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/intervals", produces = APPLICATION_JSON_VALUE)
public class IntervalsController {
    @Autowired
    private IntervalsService intervalsService;

    @PostMapping(value = "merge")
    public <T> ResponseEntity<Void> merge(@RequestParam IntervalKind kind, @RequestBody Object intervals) {
        switch (kind) {
            case digits -> {
                intervalsService.mergeDigitIntervals((List<List<Integer>>)intervals);
            }
            case letters -> {
                intervalsService.mergeLetterIntervals((List<List<String>>)intervals);
            }
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "min")
    public List<? extends Serializable> min(@RequestParam IntervalKind kind) {
        switch (kind) {
            case digits -> {
                return intervalsService.getMinDigitInterval();
            }
            case letters -> {
                return intervalsService.getMinLetterInterval();
            }
        }
        return null;
    }
}
