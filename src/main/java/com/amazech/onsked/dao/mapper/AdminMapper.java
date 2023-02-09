package com.amazech.onsked.dao.mapper;

import com.amazech.onsked.domain.*;
import com.amazech.onsked.exceptions.DataAccessException;
import com.amazech.onsked.util.OnskedList;

import java.util.List;

public interface AdminMapper {

    // Add the Business Categories to database
    Integer addBusinessCategory(Category category) throws DataAccessException;

    // Update the Business Categories for a given categoryId
    void updateBusinessCategory(Category category) throws DataAccessException;

    // Get the details for a particular Category given categoryCode
    Category getCategoryByCategoryCode(Integer categoryCode) throws DataAccessException;

    // get the business category by category name
    Category getCategoryByCategoryName(String categoryName) throws DataAccessException;

    //Activate or De-activate a Business Category
    void enableDisableCategory(Integer categoryCode) throws DataAccessException;

    // Add the Service to database
    void addServiceToCategory(ServiceMaster servicemaster) throws DataAccessException;

    // Get the details for a particular service given servicecode
    ServiceMaster getServiceByServiceCode(String serviceCode) throws DataAccessException;

    // update the Service to database
    void updateServiceDetails(ServiceMaster service) throws DataAccessException;

    // Get categories
    List<Category> getAllCategories() throws DataAccessException;

    //Check if the service already exists or if the Service Code is already used
    Integer checkService(ServiceMaster service) throws DataAccessException;

    //Add new Service for Master Category
    void addService(ServiceMaster service) throws DataAccessException;

    //Get service by Service code and category code
    ServiceMaster getServiceByCategoryCodeServiceCode(String categoryCode,String serviceCode) throws DataAccessException;

    //Update Service details
    void updateService(ServiceMaster cmdService, String categoryCodePresent,String serviceCodePresent) throws DataAccessException;

    //Delete Service of particular Category using categoryCode and serviceCode
    void deleteService(String categoryCode, String serviceCode) throws DataAccessException;

    // Get services
    List<ServiceMaster> getAllServices() throws DataAccessException;

    //Get Master Services for a Given categoryCode
    List<ServiceMaster> getMasterServices(Integer categoryCode) throws DataAccessException;

    //Enable or Disable a Country default Holiday
    void enableDisableHoliday(String countryCode, String holidayDt) throws DataAccessException;

    //Check if the default Holiday to be added already exists
    Integer checkDefaultHoliday(String countryCode, String holidayDt) throws DataAccessException;

    //Add default Holiday details of a Country
    Holiday addDefaultHoliday(Holiday holiday) throws DataAccessException;

    //Get default Holiday by Holiday Date and CountryCode
    Holiday getHolidayByDateAndCountry(String countryCode, String holidayDt) throws DataAccessException;

    //Update default Holiday detail
    void updateDefaultHoliday(Holiday cmdHoliday, String countryCode, String holidayDt) throws DataAccessException;

    //Get all Master Countries
    List<Country> getAllCountries() throws DataAccessException;

    //Check if the Country name already exists or if the Country Code is already used
    Integer checkCountryByCountryName(String countryName) throws DataAccessException;

    //Check if the Country code already exists or if the Country Code is already used
    Integer checkCountryByCountryCode(String countryCode) throws DataAccessException;

    //Add new Master Country
    void addCountry(Country country) throws DataAccessException;

    //Get the Country details by Country Code
    Country getCountryByCountryCode(String countryCode) throws DataAccessException;

    //Update Country details
    void updateCountry(Country cmdCountry, String countryCodePresent) throws DataAccessException;

    //Delete country by countryCode
    void deleteCountry(String countryCode) throws DataAccessException;

    //Get all states of master Countries
    OnskedList getAllStatesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Get all states of a particular Country
    OnskedList getCountryStates(String countryCode,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Delete State of particular Country using countryCode and stateCode
    void deleteState(String countryCode, String stateCode) throws DataAccessException;

    //Add new state for Master Country
    void addState(State state) throws DataAccessException;

    //Check if the State already exists or if the State Code is already used
    Integer checkState(State state) throws DataAccessException;

    //Get state by State code and country code
    State getStateByCountryCodeStateCode(String countryCode, String stateCode) throws DataAccessException;

    //Update State details
    void updateState(State cmdState, String countryCodePresent,String stateCodePresent) throws DataAccessException;

    //Activate or De-activate a Business
    void enableDisableBusiness(Integer bizId) throws DataAccessException;

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
    OnskedList getAllActiveOnskedUsersBySort(int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    OnskedList getUpgradeOptionsBySort(int pageSize,int pageNo, String sortBy, String sort) throws DataAccessException;

    //Add Payment details for the User
    void addPaymentDetails(Payment payment,String requestPath) throws DataAccessException;

    void insertSubscription(int userId,int numberOfBusiness,int numberOfLocation,int numberOfResource,String requestPath) throws DataAccessException;

    void updateExpiryDate(String expiryDate,Integer userId,String requestPath) throws DataAccessException;

    String getExpiryDate(Integer userId) throws DataAccessException;

    //Upgrade User (Change User Role)
    void upgradeUser(Integer userId) throws DataAccessException;

    // get list of users by email id
    OnskedList getUsersByEmailId(String searchElement,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;


    // get the featured business by sort list to admin
    OnskedList getFeaturedBusinessesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // Get categories
    OnskedList getAllCategoriesBySort(int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;

    OnskedList getAllServicesBySort(int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    //Get Master Services for a Given categoryCode
    OnskedList getMasterServicesBySort(Integer categoryCode,int pageSize,int pageNo,String sortBy,String sort) throws DataAccessException;

    // get the list of services depending on search criteria
    OnskedList getServicesOfSearchElement(Integer filterService, String searchElement, int pageSize, int pageNo, String sortBy, String sort) throws DataAccessException;



    //updating isActive flag in user table for blocking and unblocking
    void updateOnskedUsers(String userId);

    //Check if the State already exists for the country
    Integer checkStateExist(String countryCode) throws DataAccessException;
    //Check if the appointments exists
    Integer checkAppointmentExists(String countryCode, String holidayDt);
}
