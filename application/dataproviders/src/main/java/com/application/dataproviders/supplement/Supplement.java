package com.application.dataproviders.supplement;

import com.application.dataproviders.IdRow;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@ToString(callSuper = true)
@Entity
public class Supplement extends IdRow {

    @Column(nullable = false, unique = true)
    private final String code;

    @Column(nullable = false)
    private final String name;

    @Column(nullable = false)
    private final String dose;

    @Column(nullable = false)
    private final String dosing;
}
