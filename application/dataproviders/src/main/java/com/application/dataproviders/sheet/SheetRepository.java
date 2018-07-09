package com.application.dataproviders.sheet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet, Long> {
    List<Sheet> findAllByPollCodeAndUserId(String pollCode, Long userId);
    Sheet findTopByPollCodeOrderByVersionDesc(String pollCode);
}
