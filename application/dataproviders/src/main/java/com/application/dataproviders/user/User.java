package com.application.dataproviders.user;

import com.application.dataproviders.IdRow;
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
