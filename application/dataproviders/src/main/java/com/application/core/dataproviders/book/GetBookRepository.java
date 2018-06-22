package com.application.core.dataproviders.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetBookRepository extends CrudRepository<BookRow, Long> {
}
