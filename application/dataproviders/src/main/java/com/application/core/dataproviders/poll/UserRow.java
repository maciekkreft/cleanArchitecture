package com.application.core.dataproviders.poll;

import com.application.core.dataproviders.IdRow;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class UserRow extends IdRow {

    @Column(nullable = false)
    private final String email;

    @Column(nullable = false)
    private final String passwordHash;
}
