package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class PollRow extends IdRow {

    @Column(nullable = false)
    private final String code;

    @Column(nullable = false)
    private final String name;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private final CategoryRow category;

}
