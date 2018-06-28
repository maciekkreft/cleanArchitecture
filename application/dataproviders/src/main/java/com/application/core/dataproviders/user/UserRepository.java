package com.application.core.dataproviders.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByIdAndSessionId(Long id, String sessionId);
}
