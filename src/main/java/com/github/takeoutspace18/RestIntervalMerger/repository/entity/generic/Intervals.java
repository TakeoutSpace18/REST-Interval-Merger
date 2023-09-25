package com.github.takeoutspace18.RestIntervalMerger.repository.entity.generic;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Intervals<T extends Comparable<T>> implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,
    nullable = false,
    unique = true)
    private Integer interval_id;

    @Column
    private T interval_start;
    @Column
    private T interval_stop;

    public Intervals(T start, T stop) {
        this.interval_start = start;
        this.interval_stop = stop;
    }
}
