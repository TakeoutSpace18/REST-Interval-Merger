package com.github.takeoutspace18.RestIntervalMerger.service;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class IntervalMerger {
    public static <T extends Comparable<T>> List<List<T>> merge(List<List<T>> intervals) {
        intervals.sort(Comparator.comparing(o -> o.get(0)));
        Stack<List<T>> mergedIntervals = new Stack<>();
        mergedIntervals.push(intervals.get(0));

        for (List<T> currInterval : intervals.subList(1, intervals.size())) {
            List<T> top = mergedIntervals.peek();
            // if interval intersects
            if (currInterval.get(0).compareTo(top.get(1)) <= 0) {
                // if curr interval extends top
                if (currInterval.get(1).compareTo(top.get(1)) > 0) {
                    mergedIntervals.pop();
                    top.set(1, currInterval.get(1));
                    mergedIntervals.push(top);
                }
            }
            else {
                mergedIntervals.push(currInterval);
            }
        }

        return mergedIntervals;
    }
}