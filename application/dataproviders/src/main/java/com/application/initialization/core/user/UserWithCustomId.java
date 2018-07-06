package com.application.initialization.core.user;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
@Table(name = "USER")
public class UserWithCustomId {
    @Id
    private final Long id;

    @Column(nullable = false, unique = true)
    private final String sessionId;

}
