package com.application.core.dataproviders.sheet;

import com.application.core.dataproviders.IdRow;
import com.application.core.dataproviders.poll.Poll;
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
public class Sheet extends IdRow {

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private final Poll poll;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false)
    private final User user;

    @ElementCollection
    private final List<Answer> answers;

}

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Embeddable
class Answer {

    @Column(nullable = false)
    private final Boolean value;
}
