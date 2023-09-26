package com.github.takeoutspace18.RestIntervalMerger.repository.generic;

import com.github.takeoutspace18.RestIntervalMerger.repository.entity.generic.Intervals;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IntervalsRepository<E extends Intervals<?>> extends CrudRepository<E, Integer> {
    @Query(value = """
        SELECT id, start, stop\s
        FROM #{#entityName}\s
        ORDER BY start, stop ASC\s
        LIMIT 1
        """,
        nativeQuery = true)
    Optional<E> findMinInterval();
}
