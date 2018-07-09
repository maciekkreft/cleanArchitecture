package com.application.dataproviders.supplement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends CrudRepository<Supplement, Long> {
}
