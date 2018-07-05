package com.application.dataproviders.session;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Session {
    @Id
    private final String id;
}
