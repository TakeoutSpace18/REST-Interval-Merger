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
    private Integer id;

    @Column
    private T start;
    @Column
    private T stop;

    public Intervals(T start, T stop) {
        this.start = start;
        this.stop = stop;
    }
}
