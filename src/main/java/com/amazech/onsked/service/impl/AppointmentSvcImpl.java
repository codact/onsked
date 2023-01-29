package com.amazech.onsked.service.impl;

import com.amazech.onsked.dao.entity.CategoryEntity;
import com.amazech.onsked.dao.mapper.UserMapper;
import com.amazech.onsked.dao.repo.AppointmentRepository;
import com.amazech.onsked.dao.repo.CategoryRepository;
import com.amazech.onsked.domain.*;
import com.amazech.onsked.service.AppointmentSvc;
import com.amazech.onsked.util.OnskedList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class AppointmentSvcImpl implements AppointmentSvc {
    @Autowired
    AppointmentRepository appointmentScheduleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Integer addBusinessCategory(Category category) {
        log.debug("Before calling DAO method addBusinessCategory()");
        CategoryEntity categoryEntity =modelMapper.map(category, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);
        return categoryEntity.getCategoryCode();
    }

    @Override
    public void updateBusinessCategory(Category category) {

    }

    @Override
    public Category getCategoryByCategoryCode(Integer categoryCode) {
        return null;
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public void enableDisableCategory(Integer categoryCode) {

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
    public List<Category> getAllCategories() {
        return null;
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
    public List<Country> getAllCountries() {
        return null;
    }

    @Override
    public Integer checkCountryByCountryName(String countryName) {
        return null;
    }

    @Override
    public Integer checkCountryByCountryCode(String countryCode) {
        return null;
    }

    @Override
    public Integer checkState(State state) {
        return null;
    }

    @Override
    public void addCountry(Country country) {

    }

    @Override
    public Country getCountryByCountryCode(String countryCodePresent) {
        return null;
    }

    @Override
    public void updateCountry(Country cmdCountry, String countryCodePresent) {

    }

    @Override
    public void deleteCountry(String countryCode) {

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
