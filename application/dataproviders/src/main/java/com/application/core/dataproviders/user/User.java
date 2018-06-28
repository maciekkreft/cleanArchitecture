package com.application.core.dataproviders.user;

import com.application.core.dataproviders.IdRow;
import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class User extends IdRow {

    @Column(nullable = false, unique = true)
    private final String sessionId;

}
