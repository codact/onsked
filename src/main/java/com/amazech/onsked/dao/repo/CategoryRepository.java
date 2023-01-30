package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {


    Optional<CategoryEntity> findByCategoryName(String name);
}
