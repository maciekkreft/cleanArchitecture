package com.application.dataproviders.poll;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Embeddable
public class Score {

    @Column(nullable = false)
    private final String medium;

    @Column(nullable = false)
    private final String high;

    public Score(int medium, int high) {
        this.medium = String.valueOf(medium);
        this.high = String.valueOf(high);
    }
}
