package com.application.core.dataproviders.poll;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryRow, Long> {
    CategoryRow findByCode(String categoryCode);
}
