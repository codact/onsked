package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.entity.CategoryEntity;
import com.amazech.onsked.dao.entity.CountryEntity;
import com.amazech.onsked.dao.repo.CategoryRepository;
import com.amazech.onsked.dao.repo.CountryRepository;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.GenericBusinessException;
import com.amazech.onsked.service.AdminSvc;
import com.amazech.onsked.util.OnskedList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AdminSvcImpl implements AdminSvc {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Integer addBusinessCategory(Category category) {
        log.debug("Before calling DAO method addBusinessCategory()");
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        categoryEntity =  categoryRepository.save(categoryEntity);
        return categoryEntity.getCategoryCode();
    }

    @Override
    public void updateBusinessCategory(Category category) {

        log.debug("Before calling DAO method updateBusinessCategory()");
        CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
        Optional<CategoryEntity> value = categoryRepository.findById(categoryEntity.getCategoryCode());
        if(value.isPresent()){
            log.debug("Existing categoryCode.");
            /*
            merge or replace
             */
            categoryRepository.save(categoryEntity);
        }else{
            log.debug("New categoryCode.");
            categoryRepository.save(categoryEntity);
        }
    }

    @Override
    public Category getCategoryByCategoryCode(Integer categoryCode) {
        log.debug("Before calling method getCategoryByCategoryCode()");
        Optional<CategoryEntity> value = categoryRepository.findById(categoryCode);
        if(value.isPresent()) {
            log.debug("categoryCode is present.");
            Category category = modelMapper.map(value.get(), Category.class);
            return category;
        }
        else{
            log.debug("categoryCode does not exist.");
            return null;
        }

    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) throws GenericBusinessException {
        log.debug("Before calling method getCategoryByCategoryName()");
        Optional<CategoryEntity> value = categoryRepository.findByCategoryName(categoryName);
        if(value.isPresent()) {
            log.debug("categoryName is present.");
            Category category = modelMapper.map(value.get(), Category.class);
            return category;
        }
        else{
            log.debug("categoryName "+categoryName+" does not exist.");
            throw new GenericBusinessException("categoryName "+categoryName+" does not exist.");
        }
    }

    @Override
    public void enableDisableCategory(Integer categoryCode) throws GenericBusinessException {

        log.debug("Before calling method enableDisableCategory()");
        Optional<CategoryEntity> value = categoryRepository.findById(categoryCode);
        if(value.isPresent()){
            CategoryEntity categoryEntity = value.get();
            if(categoryEntity.getIsActive().equalsIgnoreCase("Y"))
                categoryEntity.setIsActive("N");
            else
                categoryEntity.setIsActive("Y");
        }
        else
            throw new GenericBusinessException("categoryCode "+categoryCode+" does not exist.");

    }

    @Override
    public void addServiceToCategory(ServiceMaster servicemaster) {

    }

    @Override
    public ServiceMaster getServiceByServiceCode(String serviceCode) {
        return null;
    }

    @Override
    public void updateServiceDetails(ServiceMaster service) {

    }

    @Override
    public List<Category> getAllCategories() throws GenericBusinessException {

        log.debug("Before calling method getAllCategories()");
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        if(!categoryEntities.isEmpty()) {
            List<Category> categories = categoryEntities.stream()
                    .map(categoryEntity -> modelMapper.map(categoryEntity, Category.class))
                    .collect(Collectors.toList());
            return categories;
        }
        else
            throw new GenericBusinessException("No Categories available!");

    }

    @Override
    public Integer checkService(ServiceMaster service) {
        return null;
    }

    @Override
    public void addService(ServiceMaster service) {

    }

    @Override
    public ServiceMaster getServiceByCategoryCodeServiceCode(String categoryCode, String serviceCode) {
        return null;
    }

    @Override
    public void updateService(ServiceMaster cmdService, String categoryCodePresent, String serviceCodePresent) {

    }

    @Override
    public void deleteService(String categoryCode, String serviceCode) {

    }

    @Override
    public List<ServiceMaster> getAllServices() {
        return null;
    }

    @Override
    public List<ServiceMaster> getMasterServices(Integer categoryCode) {
        return null;
    }

    @Override
    public void enableDisableHoliday(String countryCode, String holidayDt) {

    }

    @Override
    public Integer checkDefaultHoliday(String countryCode, String holidayDt) {
        return null;
    }

    @Override
    public Holiday addDefaultHoliday(Holiday holiday) {
        return null;
    }

    @Override
    public Holiday getHolidayByDateAndCountry(String countryCode, String holidayDt) {
        return null;
    }

    @Override
    public void updateDefaultHoliday(Holiday cmdHoliday, String countryCode, String holidayDt) {

    }

    @Override
    public List<Country> getAllCountries() throws GenericBusinessException {
        log.debug("Before calling method getAllCountries()");
        List<CountryEntity> countryEntities = countryRepository.findAll();

        if(!countryEntities.isEmpty()) {
            List<Country> countries = countryEntities.stream()
                    .map(countryEntity -> modelMapper.map(countryEntity, Country.class))
                    .collect(Collectors.toList());
            return countries;
        }
        else
            throw new GenericBusinessException("No Countries available!");
    }

    @Override
    public Integer checkCountryByCountryName(String countryName) {
        log.debug("Before calling method checkCountryByCountryName()");
        List<CountryEntity> countries = countryRepository.findAllByCountryName(countryName);
        return countries.size();
    }

    @Override
    public Integer checkCountryByCountryCode(String countryCode) {
        log.debug("Before calling method checkCountryByCountryName()");
        List<CountryEntity> countries = countryRepository.findAllByCountryCode(countryCode);
        return countries.size();
    }

    @Override
    public Integer checkState(State state) {
        return null;
    }

    @Override
    public void addCountry(Country country) {
        log.debug("Before calling method addCountry()");
        countryRepository.save(modelMapper.map(country, CountryEntity.class));
    }

    @Override
    public Country getCountryByCountryCode(String countryCodePresent) throws GenericBusinessException {
        log.debug("Before calling method getCountryByCountryCode()");
        Optional<CountryEntity> countryEntity = countryRepository.findById(countryCodePresent);
        if(countryEntity.isPresent()){
            log.debug("countryCode present.");
            Country country = modelMapper.map(countryEntity.get(), Country.class);
            return country;
        }
        else
            throw new GenericBusinessException("countryCode "+countryCodePresent+" does not exist.");
    }

    @Override
    public void updateCountry(Country cmdCountry, String countryCodePresent) {

    }

    @Override
    public void deleteCountry(String countryCode) {
        log.debug("Before calling method deleteCountry()");
        countryRepository.deleteById(countryCode);
    }

    @Override
    public OnskedList getAllStatesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getCountryStates(String countryCode, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void deleteState(String countryCode, String stateCode) {

    }

    @Override
    public void addState(State state) {

    }

    @Override
    public State getStateByCountryCodeStateCode(String countryCode, String stateCode) {
        return null;
    }

    @Override
    public void updateState(State cmdState, String countryCodePresent, String stateCodePresent) {

    }

    @Override
    public void enableDisableBusiness(Integer bizId) {

    }

    @Override
    public List<Business> getFeaturedBusinesses() {
        return null;
    }

    @Override
    public OnskedList getCategoriesOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getCountriesOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getStatesOfSearchElement(String filterState, String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getHolidaysOfSearchElement(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public int checkStateIsEditable(String countryCode, String stateCode) {
        return 0;
    }

    @Override
    public void markOrRemoveFeaturedBusiness(Integer bizId, Integer userId) {

    }

    @Override
    public OnskedList getAllActiveOnskedUsersBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getUpgradeOptionsBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void addPaymentDetails(Payment payment, String requestPath) {

    }

    @Override
    public void insertSubscription(int userId, int numberOfBusiness, int numberOfLocation, int numberOfResource, String requestPath) {

    }

    @Override
    public void updateExpiryDate(String expiryDate, Integer userId, String requestPath) {

    }

    @Override
    public String getExpiryDate(Integer userId) {
        return null;
    }

    @Override
    public void upgradeUser(Integer userId) {

    }

    @Override
    public OnskedList getUsersByEmailId(String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getFeaturedBusinessesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getAllCategoriesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getAllServicesBySort(int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getMasterServicesBySort(Integer categoryCode, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public OnskedList getServicesOfSearchElement(Integer filterService, String searchElement, int pageSize, int pageNo, String sortBy, String sort) {
        return null;
    }

    @Override
    public void updateOnskedUsers(String userId) {

    }

    @Override
    public Integer checkStateExist(String countryCode) {
        return null;
    }

    @Override
    public Integer checkAppointmentExists(String countryCode, String holidayDt) {
        return null;
    }
}
