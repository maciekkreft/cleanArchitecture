package com.application.dataproviders.sheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet, Long> {
    boolean existsByPollCodeAndUserIdAndVersion(
            String pollCode,
            Long userId,
            Long version
    );

    List<Sheet> findAllByPollCodeAndUserId(String pollCode, Long userId);
}
