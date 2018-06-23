package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class CategoryRow extends IdRow {

    @Column(nullable = false)
    private final String code;

    @Column(nullable = false)
    private final String name;

}
