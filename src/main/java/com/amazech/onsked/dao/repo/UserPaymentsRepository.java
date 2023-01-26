package com.amazech.onsked.dao.repo;


import com.amazech.onsked.dao.entity.UserPaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPaymentsRepository extends JpaRepository<UserPaymentsEntity, Integer> {
}
