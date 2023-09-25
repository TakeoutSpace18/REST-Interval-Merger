package com.github.takeoutspace18.RestIntervalMerger.repository.generic;

import com.github.takeoutspace18.RestIntervalMerger.repository.entity.generic.Intervals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IntervalsRepository<E extends Intervals<?>> extends CrudRepository<E, Integer> {
    @Query(value = "SELECT INTERVAL_ID, INTERVAL_START, INTERVAL_STOP FROM #{#entityName} ORDER BY INTERVAL_START, INTERVAL_STOP ASC LIMIT 1",
    nativeQuery = true)
    Optional<E> findMinInterval();
}
