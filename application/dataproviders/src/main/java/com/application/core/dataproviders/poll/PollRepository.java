package com.application.core.dataproviders.poll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
    boolean existsByCode(String pollCode);
}
