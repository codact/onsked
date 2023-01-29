package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, Integer> {
}
