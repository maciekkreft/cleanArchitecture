package com.application.dataproviders.sheet;

import com.application.dataproviders.IdRow;
import com.application.dataproviders.poll.Poll;
import com.application.dataproviders.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
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
    private final Long version;

    @ElementCollection
    private final List<Answer> answers;

    @Column(nullable = false)
    private final Date createdAt;

}

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Embeddable
class Answer {

    @Column(nullable = false)
    private final Boolean value;
}
