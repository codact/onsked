package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.CountryEntity;
import com.amazech.onsked.dao.entity.ServiceMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceMasterRepository extends JpaRepository<ServiceMasterEntity, Integer> {

    List<ServiceMasterEntity> findAllByServiceCode(Integer serviceCode);
    List<ServiceMasterEntity> findAllByServiceName(String serviceName);
    Optional<ServiceMasterEntity> findByServiceCodeAndCategoryCode(Integer serviceCode, String categoryCode);
    List<ServiceMasterEntity> findByCategoryCodeAndIsActive(String categoryCode, String isActive);
}
