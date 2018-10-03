package com.mobilenoc.sync.repo;

import com.mobilenoc.sync.entity.TableTwo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableTwoRepository extends CrudRepository<TableTwo, Integer> {
}
