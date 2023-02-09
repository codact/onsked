package com.amazech.onsked.dao.repo;

import com.amazech.onsked.dao.entity.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, String> {

    Optional<HolidayEntity> findByCountryCodeAndHolidayDt(String countryCode, String holidayDt);
}
