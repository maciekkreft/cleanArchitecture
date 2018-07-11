package com.application.dataproviders.sheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet, Long> {
    List<Sheet> findAllByPollCodeAndUserId(String pollCode, Long userId);
    Sheet findTopByPollCodeAndUserIdOrderByVersionDesc(String pollCode, Long userId);
    Sheet findOneByVersionAndPollCodeAndUserId(Long version, String pollCode, Long userId);
}
