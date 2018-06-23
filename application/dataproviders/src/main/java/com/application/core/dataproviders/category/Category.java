package com.application.core.dataproviders.category;

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
public class Category extends IdRow {

    @Column(nullable = false, unique = true)
    private final String code;

    @Column(nullable = false)
    private final String name;

}