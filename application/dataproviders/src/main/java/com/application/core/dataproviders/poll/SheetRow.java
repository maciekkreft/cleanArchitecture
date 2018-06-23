package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class SheetRow extends IdRow {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sheet")
    private final List<AnswerRow> answers;

}
