package com.mobilenoc.sync.repo;

import com.mobilenoc.sync.entity.Sync;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyncRepository extends CrudRepository<Sync, Integer> {
}
