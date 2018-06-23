package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class AnswerRow extends IdRow {

    @Column(nullable = false)
    private final Boolean value;

    @ManyToOne
    private final SheetRow sheet;
}
