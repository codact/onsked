package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.StateEntity;
import com.amazech.onsked.dao.entity.StateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, StateId> {
}
