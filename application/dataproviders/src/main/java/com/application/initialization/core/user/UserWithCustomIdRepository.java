package com.application.initialization.core.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWithCustomIdRepository extends CrudRepository<UserWithCustomId, Long> {
}
