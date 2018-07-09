package com.application.dataproviders.poll;

import com.application.dataproviders.IdRow;
import com.application.dataproviders.category.Category;
import com.application.dataproviders.supplement.Supplement;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Poll extends IdRow {

    @Column(nullable = false, unique = true)
    private final String code;

    @Column(nullable = false)
    private final String name;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private final Category category;

    @ElementCollection
    private final List<Question> questions;

    @Embedded
    @Column(nullable = false)
    private final Score scores;

    @ManyToMany(cascade = CascadeType.ALL)
    private final List<Supplement> supplements;

}
