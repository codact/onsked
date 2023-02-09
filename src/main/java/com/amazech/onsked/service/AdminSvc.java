package com.amazech.onsked.service;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.exceptions.GenericBusinessException;
import com.amazech.onsked.util.OnskedList;

import java.util.List;

public interface AdminSvc {

    // Add the Business Categories to database
    Integer addBusinessCategory(Category category);

    // Update the Business Categories for a given categoryId
    void updateBusinessCategory(Category category) throws GenericBusinessException;

    // Get the details for a particular Category given categoryCode
    Category getCategoryByCategoryCode(Integer categoryCode);

    // get the business category by category name
    Category getCategoryByCategoryName(String categoryName) throws GenericBusinessException;

    //Activate or De-activate a Business Category
    void enableDisableCategory(Integer categoryCode) throws GenericBusinessException;

    // Add the Service to database
    void addServiceToCategory(ServiceMaster servicemaster);

    // Get the details for a particular service given servicecode
    ServiceMaster getServiceByServiceCode(String serviceCode) throws GenericBusinessException;

    // update the Service to database
    void updateServiceDetails(ServiceMaster service) throws GenericBusinessException;

    // Get categories
    List<Category> getAllCategories() throws GenericBusinessException;

    //Check if the Service already exists or if the Service Code is already used
    Integer checkService(ServiceMaster service);

    //Add new service for Master Category
    void addService(ServiceMaster service);

    //Get service by Service code and category code
    ServiceMaster getServiceByCategoryCodeServiceCode(String categoryCode,String serviceCode) throws GenericBusinessException;

    //Update Service details
    void updateService(ServiceMaster cmdService, String categoryCodePresent,String serviceCodePresent) throws GenericBusinessException;

    //Delete Service of particular Category using categoryCode and serviceCode
    void deleteService(String categoryCode, String serviceCode) throws GenericBusinessException;

    // get all services of all categories
    List<ServiceMaster> getAllServices() throws GenericBusinessException;

    //Get Master Services for a Given categoryCode
    List<ServiceMaster> getMasterServices(Integer categoryCode) throws GenericBusinessException;

    //Enable or Disable a Country default Holiday
    void enableDisableHoliday(String countryCode, String holidayDt) throws GenericBusinessException;

    //Check if the default Holiday to be added already exists
    Integer checkDefaultHoliday(String countryCode, String holidayDt);

    //Add default Holiday details of a Country
    Holiday addDefaultHoliday(Holiday holiday);

    //Get default Holiday by Holiday Date and CountryCode
    Holiday getHolidayByDateAndCountry(String countryCode, String holidayDt) throws GenericBusinessException;

    //Update default Holiday detail
    void updateDefaultHoliday(Holiday cmdHoliday, String countryCode, String holidayDt) throws GenericBusinessException;

    //Get all Master Countries
    List<Country> getAllCountries() throws GenericBusinessException;

    //Check if the Country name already exists or if the Country Code is already used
    Integer checkCountryByCountryName(String countryName) ;

    //Check if the Country code already exists or if the Country Code is already used
    Integer checkCountryByCountryCode(String countryCode) ;

    //Check if the State already exists or if the State Code is already used
    Integer checkState(State state) throws DataAccessException;

    //Add new Master Country
    void addCountry(Country country);

    //Get country details by Country Code
    Country getCountryByCountryCode(String countryCodePresent) throws GenericBusinessException;

    //Update Country details
    void updateCountry(Country cmdCountry, String countryCodePresent) throws GenericBusinessException;

    //Delete Country using Country code
    void deleteCountry(String countryCode);

    //Get all states of master Countries
    OnskedList getAllStatesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Get all states of a particular Country
    OnskedList getCountryStates(String countryCode,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Delete State of particular Country using countryCode and stateCode
    void deleteState(String countryCode, String stateCode);

    //Add new state for Master Country
    void addState(State state);

    //Get state by State code and country code
    State getStateByCountryCodeStateCode(String countryCode,String stateCode) throws GenericBusinessException;

    //Update State details
    void updateState(State cmdState, String countryCodePresent,String stateCodePresent) throws GenericBusinessException;

    //Activate or De-activate a Business
    void enableDisableBusiness(Integer bizId) throws GenericBusinessException;

    // get the featured business list to admin
    List<Business> getFeaturedBusinesses() throws DataAccessException;

    // get the list of categories depending on search criteria
    OnskedList getCategoriesOfSearchElement(String searchElement,int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    // get the list of countries depending on search criteria
    OnskedList getCountriesOfSearchElement(String searchElement,int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    // get the list of states depending on search criteria
    OnskedList getStatesOfSearchElement(String filterState,String searchElement,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // get the list of holidays depending on search criteria
    OnskedList getHolidaysOfSearchElement(String searchElement,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Check if the State code is used in another tables
    int checkStateIsEditable(String countryCode,String stateCode) throws DataAccessException;

    // add or remove featured business
    void markOrRemoveFeaturedBusiness(Integer bizId,Integer userId) throws DataAccessException;

    // get all the active onsked user list
    OnskedList  getAllActiveOnskedUsersBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    OnskedList getUpgradeOptionsBySort(int pageSize,int pageNo, String sortBy, String sort) throws DataAccessException;

    //Add Payment details for the User
    void addPaymentDetails(Payment payment,String requestPath) throws DataAccessException;

    void insertSubscription(int userId,int numberOfBusiness,int numberOfLocation,int numberOfResource,String requestPath) throws DataAccessException;

    //Update Payment expiry date for the User
    void updateExpiryDate(String expiryDate,Integer userId,String requestPath) throws DataAccessException;

    String getExpiryDate(Integer userId) throws DataAccessException;

    //Upgrade User (Change User Role)
    void upgradeUser(Integer userId) throws GenericBusinessException;

    // get list of users by email id
    OnskedList getUsersByEmailId(String searchElement,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // get the featured business list to admin
    OnskedList getFeaturedBusinessesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    OnskedList getAllCategoriesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // get all services of all categories
    OnskedList getAllServicesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Get Master Services for a Given categoryCode
    OnskedList getMasterServicesBySort(Integer categoryCode, int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    // get the list of services depending on search criteria
    OnskedList getServicesOfSearchElement(Integer filterService,String searchElement,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // updating isActive flag in user table for blocking and unblocking
    void updateOnskedUsers(String userId);


    //Check if the State already exists for the country
    Integer checkStateExist(String countryCode) throws DataAccessException;
    //Check if the appointments exists
    Integer checkAppointmentExists(String countryCode, String holidayDt);

}
