package com.application.core.dataproviders.poll;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Embeddable
public class Question {

    @Column(nullable = false, length = 512)
    private final String content;

}
