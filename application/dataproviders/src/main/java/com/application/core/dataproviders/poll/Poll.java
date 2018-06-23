package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import com.application.core.dataproviders.category.Category;
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

}

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Embeddable
class Question {

    @Column(nullable = false)
    private final String content;

}
