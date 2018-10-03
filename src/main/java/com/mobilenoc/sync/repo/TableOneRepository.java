package com.mobilenoc.sync.repo;

import com.mobilenoc.sync.entity.TableOne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableOneRepository extends CrudRepository<TableOne,Integer> {
}
