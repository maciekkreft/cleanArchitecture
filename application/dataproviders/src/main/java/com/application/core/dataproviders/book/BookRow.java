package com.application.core.dataproviders.book;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class BookRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @Column(nullable = false)
    private final String title;
}
