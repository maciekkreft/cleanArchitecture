package com.application.dataproviders.sheet;

import com.application.dataproviders.IdRow;
import com.application.dataproviders.poll.Poll;
import com.application.dataproviders.user.User;
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

    @Column(nullable = false)
    final Long version;

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
