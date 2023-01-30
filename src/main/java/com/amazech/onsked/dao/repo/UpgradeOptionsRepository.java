package com.amazech.onsked.dao.repo;


import com.amazech.onsked.dao.entity.UpgradeOptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpgradeOptionsRepository extends JpaRepository<UpgradeOptionsEntity, Integer> {
}
