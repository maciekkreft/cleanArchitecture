package com.application.dataproviders.category;

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
public class Category extends IdRow {

    @Column(nullable = false, unique = true)
    private final String code;

    @Column(nullable = false)
    private final String name;

}
