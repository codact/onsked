package com.amazech.onsked.dao.repo;


import com.amazech.onsked.dao.entity.UnregisteredUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnregisteredUserRepository extends JpaRepository<UnregisteredUserEntity, Integer> {
}
