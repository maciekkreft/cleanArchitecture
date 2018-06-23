package com.application.core.dataproviders.sheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet, Long> {
    boolean existsByPollCodeAndUserEmailAndVersion(
            String pollCode,
            String userEmail,
            Long version
    );

    List<Sheet> findAllByPollCodeAndUserEmail(String pollCode, String userEmail);
}
