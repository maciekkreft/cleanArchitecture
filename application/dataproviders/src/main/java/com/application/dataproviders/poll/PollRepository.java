package com.application.dataproviders.poll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
    boolean existsByCode(String pollCode);
    Poll findByCode(String pollCode);
}
