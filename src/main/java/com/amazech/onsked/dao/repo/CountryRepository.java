package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.CategoryEntity;
import com.amazech.onsked.dao.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String> {

    Optional<CountryEntity> findByCountryName(String name);
    List<CountryEntity> findAllByCountryName(String name);
    List<CountryEntity> findAllByCountryCode(String code);
}
